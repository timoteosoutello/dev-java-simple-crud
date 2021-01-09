package com.github.builder;

import com.github.dto.UserClickDTO;
import com.github.model.UserClick;

public class UserClickBuilder {

    public static UserClick buildUserClick(UserClickDTO userClickDTO) {
	return new UserClick(userClickDTO.getPath());
    }
}
