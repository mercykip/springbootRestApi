package com.springboot.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springboot.entity.User;
import com.springboot.repository.UsersRepository;


@RestController
@CrossOrigin
public class UsersController {
	@Autowired
	UsersRepository usersRepository;

/// add user
  @ResponseBody
  @RequestMapping(value = "/registration", method = RequestMethod.POST, 
   consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,
		"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<?> registration(@ModelAttribute User userJson )
	{
	Gson gson = new Gson();
		String name = userJson.getName();//reqObj.get("name").getAsString();
		String email = userJson.getEmail();//reqObj.get("name").getAsString();
		String occupation = userJson.getOccupation();//reqObj.get("name").getAsString();
		String bio = userJson.getBio();//reqObj.get("name").getAsString();
		User user=usersRepository.save(userJson);
		
		if(user!=null) {
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
		else
		{
		  return	new ResponseEntity<>("Registration failed", HttpStatus.OK);
		}
	}
  
    //delete user
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id)
	   {
		usersRepository.deleteById(id);;
		    return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	   }
           
	/// get all users
	@GetMapping(value="/users")
	public List<User>  getAllUsers()
		{
		  return  usersRepository.findAll();
		}
	
	//get user
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) 
	{
         User User=usersRepository.getById(id);
        return User;
	}
	
	 // update user
	@RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id,@RequestBody User User)
	{
    User Users=usersRepository.getById(id);	
    if(Users!=null) {
	    Users.setBio(User.getBio());
	    Users.setEmail(User.getEmail());
	    Users.setOccupation(User.getOccupation());;
	    usersRepository.save(Users);
	return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);   
     }
    else {
    	return new ResponseEntity<>("User not found", HttpStatus.OK);   
    }
    }

		    
  
   
}
