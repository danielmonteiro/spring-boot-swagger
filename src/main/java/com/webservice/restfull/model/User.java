package com.webservice.restfull.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Description of User object")
public class User {

	private Integer id;
	
	@ApiModelProperty(notes = "Name should be at least 2 characters")
	private String name;
	
	@ApiModelProperty(notes = "Birthdate should be in past")
	private Date birthDate;
	
	@JsonIgnore
	private String hiddenProperty;
	
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
	
	
	
}
