package com.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.model.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "content")
public interface UserRepository extends JpaRepository<User, String>, QuerydslPredicateExecutor<User> {

}
