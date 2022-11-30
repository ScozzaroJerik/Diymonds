package com.javasampleapproach.diymonds.repo;


import com.javasampleapproach.diymonds.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}