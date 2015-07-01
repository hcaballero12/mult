package com.lokiton.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="gropi")
public class Group {
	
	@Id
	@GeneratedValue
	private long groupId;
	
	@Column
	private String name;
	private int numOfMembers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "lokiton_group",joinColumns = @JoinColumn(name = "groupId"),inverseJoinColumns=@JoinColumn(name="lokitonId"))
	private Set<Lokiton> lokitons;

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfMembers() {
		return lokitons.size();
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public Set<Lokiton> getLokitons() {
		return lokitons;
	}

	public void setLokitons(Set<Lokiton> lokitons) {
		this.lokitons = lokitons;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", name=" + name
				+ ", numOfMembers=" + numOfMembers + ", lokitons=" + lokitons
				+ "]";
	}
	
	
	
	
	

}
