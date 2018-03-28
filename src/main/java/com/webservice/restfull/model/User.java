package com.webservice.restfull.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Description of User object")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should be at least 2 characters")
	@ApiModelProperty(notes = "Name should be at least 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birthdate should be in past")
	private Date birthDate;
	
	@JsonIgnore
	private String hiddenProperty;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.hiddenProperty = "Hidden property";
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHiddenProperty() {
		return hiddenProperty;
	}

	public void setHiddenProperty(String hiddenProperty) {
		this.hiddenProperty = hiddenProperty;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
}
