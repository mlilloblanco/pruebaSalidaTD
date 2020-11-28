package org.mlb.pruebaSalidaTD.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@Column(name = "employeeNumber", nullable = false, unique = true, updatable = false)
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "officeCode")
	@JsonIgnore
	private Office office;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reportsTo")
	@JsonIgnore
	private Employee manager;
	
	private String jobTitle;
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Employee> employees;

	public Employee() {
		super();
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
