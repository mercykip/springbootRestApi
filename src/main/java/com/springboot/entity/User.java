package com.springboot.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
    	@GeneratedValue(strategy = GenerationType.AUTO) 
		
	    private Integer id;
		@NotBlank(message = "Name is mandatory")
	    private String name;
		@Email(message = "Email is invalid")
		@Column(unique = true)
		@NotBlank(message = "Name is mandatory")
		private String email;
		@NotBlank(message = "Name is mandatory")
		private String bio;
		@NotBlank(message = "Name is mandatory")
	    private String occupation;
	   
	    
	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}


		public User(Integer id, String name, String email, String bio, String occupation) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.bio = bio;
			this.occupation = occupation;
		}
	    
	    
	    public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBio() {
			return bio;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}


}
