package nl.harmster.dao;

import java.util.List;

import nl.harmster.domain.Employee;

public interface DataDao {
 public int insertRow(Employee employee);

 public List getList();

 public Employee getRowById(int id);

 public int updateRow(Employee employee);

 public int deleteRow(int id);

}