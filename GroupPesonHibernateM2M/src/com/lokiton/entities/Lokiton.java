package com.lokiton.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lokiton {
	
	@Id
	@GeneratedValue
	private Long lokId;
	
	@Column
	private String user;
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy = "lokitons")
	private Set<Group> group;

	public Long getLokId() {
		return lokId;
	}

	public void setLokId(Long lokId) {
		this.lokId = lokId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Group> getGroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Lokiton [lokId=" + lokId + ", user=" + user + ", email="
				+ email + ", group=" + group + "]";
	}
	
	
	

}
