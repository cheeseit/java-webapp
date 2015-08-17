package nl.harmster.services;

import nl.harmster.domain.UserAccount;

public interface AccountDataService {
	
	public UserAccount getUserAccountById(int id);
	
	public void createUserAccount(UserAccount ua);
	
}
