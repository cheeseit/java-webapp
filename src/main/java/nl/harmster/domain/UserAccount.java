package nl.harmster.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue
	private int id;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Employee> employee;
	private String username;
	private String password;
	@Column
	@ElementCollection(targetClass=Permissions.class)
	private List<Permissions> permissions;


	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Permissions> getPermissions() {
		return permissions;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}

	public int getId() {
		return id;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

}
