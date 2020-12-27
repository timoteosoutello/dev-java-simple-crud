package com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.controller.UserController;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void dummyTest() {
	userController.query(getPredicate(), getPageable());
    }
    
    private Pageable getPageable() {
	return PageRequest.of(0, 20);
    }
    private Predicate getPredicate() {
	BooleanBuilder builder = new BooleanBuilder();
        return builder;
    }
}
