package dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Super_Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sdepid;
	
	@Column
	private String name;
	private String manager;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sdept")
	private Set<Employee> employee;

	public long getSdepid() {
		return sdepid;
	}

	public void setSdepid(long sdepid) {
		this.sdepid = sdepid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	

}
