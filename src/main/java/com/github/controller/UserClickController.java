package com.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dto.UserClickDTO;
import com.github.usecase.UserClickUsecase;

@RestController
@RequestMapping("/v1/user-tracking")
public class UserClickController {

    @Autowired
    private UserClickUsecase userClickUsecase;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserClickDTO userClickDTO) {
    	userClickUsecase.includeUserTracking(userClickDTO);
    	return new ResponseEntity<String>(HttpStatus.OK);
    }
}
