package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Super_Employees")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sempid;
	
	
	@Column
	private String name;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "sdepid")
	private Department sdept;

	public long getSempid() {
		return sempid;
	}

	public void setSempid(long sempid) {
		this.sempid = sempid;
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

	public Department getSdept() {
		return sdept;
	}

	public void setSdept(Department sdept) {
		this.sdept = sdept;
	}

	@Override
	public String toString() {
		return "Employee [sempid=" + sempid + ", name=" + name + ", email="
				+ email + ", sdept=" + sdept + "]";
	}

	
}
