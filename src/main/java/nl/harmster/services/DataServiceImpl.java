package nl.harmster.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.dao.DataDao;
import nl.harmster.domain.Employee;
import nl.harmster.utility.database.DatabasePopulator;

public class DataServiceImpl implements DataService {
 
 @Autowired
 DataDao dataDao;
 final static Logger logger = Logger.getLogger(DataServiceImpl.class);
 
 public int insertRow(Employee employee) {
  logger.info("calling insertrow from dataDao");
  return dataDao.insertRow(employee);
 }

 public List getList() {
  return dataDao.getList();
 }

 public Employee getRowById(int id) {
  return dataDao.getRowById(id);
 }

 public int updateRow(Employee employee) {
  return dataDao.updateRow(employee);
 }

 public int deleteRow(int id) {
  return dataDao.deleteRow(id);
 }

}