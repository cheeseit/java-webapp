package nl.harmster.dao;

import nl.harmster.domain.Employee;
import nl.harmster.domain.UserAccount;

public interface AccountDataDao {
	
	public UserAccount getUserAccountById(int id);
	
	public UserAccount getUserAccountByEmployee(Employee emp);
	
	public void createNewAccount(UserAccount ua);
	
}
