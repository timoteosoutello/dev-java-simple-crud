package com.github;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.dto.UserClickDTO;
import com.github.model.UserClick;
import com.github.repository.UserClickRepository;
import com.github.usecase.UserClickUsecase;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserClickUsecaseTest {

  @Autowired
  private UserClickUsecase userClickUsecase;

  @Autowired
  private UserClickRepository userClickRepository;

  @BeforeEach
  public void setup() {
    userClickRepository.deleteAll();
  }

  @Test
  public void includeTrackingPathSuccessTest() {
    UserClickDTO userClickDTO = new UserClickDTO();
    // As I receive a new useClick entity
    userClickDTO.setPath("TEST");
    Optional<UserClick> userClickFoundOptional = userClickRepository.findByPath(userClickDTO.getPath());
    // Check if was saved
    UserClick userClickSaved = userClickUsecase.includeUserTracking(userClickDTO);
    // Check if the counter really was incremented
    if (userClickFoundOptional.isPresent()) {
      assert userClickSaved.getNumberOfClicks().equals(userClickFoundOptional.get().getNumberOfClicks() + 1);
    } else {
      assert userClickSaved.getNumberOfClicks().equals(1L);
    }
  }

  @Test
  public void includeTrackingPathWithEmptyFieldTest() {

  }
}
