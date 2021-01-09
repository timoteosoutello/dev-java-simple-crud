package com.github.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.model.UserClick;

@Repository
public interface UserClickRepository extends JpaRepository<UserClick, String> {

    @Query(" from UserClick where path = ?1")
    Optional<UserClick> findByPath(String path);

}
