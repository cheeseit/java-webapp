package nl.harmster.services;

import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.dao.AccountDataDao;
import nl.harmster.domain.UserAccount;

public class AccountDataServiceImpl implements AccountDataService {

	@Autowired
	AccountDataDao accountDataDao;
	
	public UserAccount getUserAccountById(int id) {
		return accountDataDao.getUserAccountById(id);
		
	}

	public void createUserAccount(UserAccount ua) {
		accountDataDao.createNewAccount(ua);
	}

}
