package net.multivision.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column
	String firstname;
	String lastname;
	String username;
	String password;
	String clearance;
	String img;
	
	
	
	public String getImage() {
		return img;
	}
	public void setImage(String image) {
		this.img = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUser() {
		return username;
	}
	public void setUser(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClearance() {
		return clearance;
	}
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", clearance=" + clearance
				+ ", image=" + img + "]";
	}
	
	
	
	
}
