package com.example.springboot.springDataExample;

import  com.example.springboot.springDataExample.service.*;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.springDataExample.entities.User;




@SpringBootApplication
@Component
@Transactional
public class SpringDataApplication {
	private static final Logger log = 
			LoggerFactory.getLogger(SpringDataApplication.class);
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringDataApplication.class, args);
		UserRepository userRepo = 
				applicationContext.getBean(UserRepository.class);
		

         log.info("create user");
		try {
		User user = new User("Jill", "Admin");
		log.info("New User is created 1: " + user.toString());
		userRepo.save(user);
		log.info("New User is created 2 : " + user);
		//userRepo.flush();

		log.info("3 userRepo.findTheName: " + userRepo.findTheName((long)1));
		
		log.info("3 userRepo.findByName: " + userRepo.findByName("Jill"));
		
		log.info("4: userRepo.findById : " + userRepo.findById(1L));
		User user2=(userRepo.findById(1L)).get();
		
		user2.setName("poonam");
		userRepo.save(user2);
		
		
		//log.info("New User is created 2 : " + user);
		}catch(Exception e)
		{e.printStackTrace();}
}
}

