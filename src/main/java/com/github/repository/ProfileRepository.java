package com.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.model.Profile;

@RepositoryRestResource(path = "profiles", collectionResourceRel = "content")
public interface ProfileRepository extends JpaRepository<Profile, String>, QuerydslPredicateExecutor<Profile> {

}
