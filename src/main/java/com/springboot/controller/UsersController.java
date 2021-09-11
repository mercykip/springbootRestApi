package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springboot.entity.Customer;
import com.springboot.repository.UsersRepository;
import org.springframework.http.MediaType;


@RestController

public class UsersController<registration> {
	@Autowired
	UsersRepository usersRepository;


  @ResponseBody
  @RequestMapping(value = "/registration", method = RequestMethod.POST, 
   consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,
		"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)

 public ResponseEntity<?> registration(@ModelAttribute Customer customerJson )
	{
	Gson gson = new Gson();
		String name = customerJson.getName();//reqObj.get("name").getAsString();
		String email = customerJson.getEmail();//reqObj.get("name").getAsString();
		String occupation = customerJson.getOccupation();//reqObj.get("name").getAsString();
		String bio = customerJson.getBio();//reqObj.get("name").getAsString();
		usersRepository.save(customerJson);
	// Send json response	// Send json response
	JsonObject responseObj = new JsonObject();
		responseObj.addProperty("response_status", true);
		responseObj.addProperty("response_message", "success");
		responseObj.addProperty("response_name", name);
		responseObj.addProperty("response_email", email);
		responseObj.addProperty("response_account_number", occupation);
		responseObj.addProperty("response_user", bio);
	
	return ResponseEntity.ok(gson.toJson(responseObj));
 }
  
  @PostMapping
  public Customer saveUser( @RequestBody Customer user) {
      return usersRepository.save(user);
  }

}