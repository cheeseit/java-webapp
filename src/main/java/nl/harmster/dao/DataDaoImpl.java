package nl.harmster.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.controller.DataController;
import nl.harmster.domain.Employee;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;
	final static Logger logger = Logger.getLogger(DataDaoImpl.class);

	@Transactional
	public int insertRow(Employee employee) {
		logger.debug("Inserting a new employee");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		logger.debug("Before inserting");
		session.saveOrUpdate(employee);
		logger.debug("Inserted");
		tx.commit();
		logger.debug("End transaction");
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	public List getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List employeeList = session.createQuery("from Employee").list();
		session.close();
		return employeeList;
	}

	public Employee getRowById(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
		return employee;
	}

	public int updateRow(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, id);
		session.delete(employee);
		tx.commit();
		Serializable ids = session.getIdentifier(employee);
		session.close();
		return (Integer) ids;
	}

}
