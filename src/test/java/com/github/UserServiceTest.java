package com.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.controller.UserController;
import com.github.model.Profile;
import com.github.model.User;
import com.github.repository.ProfileRepository;
import com.github.repository.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

	@Autowired
	private UserController userController;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@BeforeEach
	public void setup() {
		userRepository.deleteAll();
	}

	@Test
	public void doGetEmptyTest() {
		Page<User> page = userController.query(getPredicate(), getPageable());
		assert page.getTotalElements() == 0;
	}

	@Test
	public void doPostFailTest() {
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
			userRepository.save(new User());
		});
	}

	@Test
	public void doPostSuccessTest() {
		Profile profile = profileRepository.save(createProfile());
		User user = createUser(profile);
		User savedUser = userRepository.save(user);
		assert savedUser != null && user.getId() != null
				&& userController.query(getPredicate(), getPageable()).getTotalElements() == 1;
	}

	private Pageable getPageable() {
		return PageRequest.of(0, 20);
	}

	private Predicate getPredicate() {
		return new BooleanBuilder();
	}

	private User createUser(Profile profile) {
		User user = new User();
		user.setEmail("teste@com");
		user.setPassword("strongPassword");
		user.setPhone("931235");
		user.setProfile(null);
		user.setName("name");
		user.setProfile(profile);
		return user;
	}

	private Profile createProfile() {
		Profile profile = new Profile();
		profile.setDescription("Master Blaster");
		return profile;
	}
}
