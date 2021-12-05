package com.example.springboot.springDataExample.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.springDataExample.entities.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT name FROM User e WHERE e.id = :id")
    public String findTheName(@Param("id") long id);
	
	 public User findByName(@Param("name") String name);


}
