package com.github.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.model.UserClick;
import com.github.repository.UserClickRepository;

@Service
public class UserClickService {

    @Autowired
    private UserClickRepository userClickRepository;

    /**
     * Return user click if found
     * 
     * @param path
     * @return UserClick instance
     */
    public Optional<UserClick> findByPath(String path) {
	if (StringUtils.isEmpty(path)) {
	    return Optional.empty();
	} else {
	    return userClickRepository.findByPath(path);
	}
    }

    /**
     * Persist entity
     * 
     * @param userClick
     * @return UserClick instance
     */
    @Transactional
    public UserClick saveOrUpdate(UserClick userClick) {
	return userClickRepository.save(userClick);
    }

}
