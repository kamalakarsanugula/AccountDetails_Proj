package com.microservice.repository;

import com.microservice.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUsersRepoJpa extends JpaRepository<AppUsers, Long> {
}
