package com.microservice.repository;

import com.microservice.model.AppUsers;
import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepo extends CrudRepository<AppUsers,Integer>{
}
