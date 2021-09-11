package com.springboot.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
    	@GeneratedValue(strategy = GenerationType.AUTO) 
		@Column(name="id")
	    private Integer id;
		@Column(name="name")
	    private String name;
		@Column(name="email")
		private String email;
		@Column(name="bio")
		private String bio;
		@Column(name="occupation")
	    private String occupation;
	   
	    
	    public Customer(Integer id, String name, String email, String bio, String occupation) {
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
