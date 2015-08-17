package nl.harmster.services;

import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.Account;
import nl.harmster.dao.AccountDataDao;

public class AccountDataServiceImpl implements AccountDataService {

	@Autowired
	AccountDataDao accountDataDao;
	
	public Account getAccountById(int id) {
		return accountDataDao.getAccountById(id);
		
	}

}
