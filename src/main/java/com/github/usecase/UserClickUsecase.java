package com.github.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.builder.UserClickBuilder;
import com.github.dto.UserClickDTO;
import com.github.model.UserClick;
import com.github.service.UserClickService;

@Component
public class UserClickUsecase {

    @Autowired
    private UserClickService userClickService;

    public synchronized UserClick includeUserTracking(UserClickDTO userClickDTO) {
	UserClick userTemp = UserClickBuilder.buildUserClick(userClickDTO);
	Optional<UserClick> userClickOptional = userClickService.findByPath(userTemp.getPath());
		if (userClickOptional.isPresent()) {
		    UserClick userClickToBePersisted = userClickOptional.get();
		    userClickToBePersisted.incrementNumberOfClicks();
		    return userClickService.saveOrUpdate(userClickToBePersisted);
		} else {
		    return userClickService.saveOrUpdate(userTemp);
		}
    }
}
