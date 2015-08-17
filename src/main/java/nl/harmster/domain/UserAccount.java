package nl.harmster.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Employee employee;
	private String username;
	private String password;
	@Column
	@ElementCollection(targetClass=Permissions.class)
	private List<Permissions> permissions;

	public Employee getEmployee() {
		return employee;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Permissions> getPermissions() {
		return permissions;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

}
