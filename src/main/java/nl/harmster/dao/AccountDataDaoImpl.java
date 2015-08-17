package nl.harmster.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.domain.Employee;
import nl.harmster.domain.UserAccount;

public class AccountDataDaoImpl implements AccountDataDao{

	@Autowired
	SessionFactory sessionFactory;
	public UserAccount getUserAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void createNewAccount(UserAccount ua) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(ua);
		tx.commit();
		session.close();
	}

	public UserAccount getUserAccountByEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
