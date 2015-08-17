package nl.harmster.utility.database;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import nl.harmster.domain.Employee;
import nl.harmster.domain.UserAccount;
import nl.harmster.services.DataService;
import nl.harmster.utility.RandomString;
import nl.harmster.domain.Permissions;

public class DatabasePopulator {

	@Autowired
	DataService dataService;
	final static Logger logger = Logger.getLogger(DatabasePopulator.class);
	
	public Employee populateDatabase(){
		logger.info("Before setters");
		Employee emp1 = new Employee();
		emp1.setEmail("mail");
		emp1.setLastName("lastname");
		emp1.setFirstName("firstname");
		return emp1;
	}
	
	public List<UserAccount> populateUserAccounts(){
		List <UserAccount> list = new ArrayList<UserAccount>();
		for (int i = 0; i <= 10; i++){
			list.add(createUserAccount());
		}
		return list;
	}
	
	public UserAccount createUserAccount(){
		UserAccount ua = new UserAccount();
		RandomString rs = new RandomString(8);
		
		List<Permissions> list = new ArrayList<Permissions>();
		list.add(Permissions.ADMIN);
		list.add(Permissions.USER);
		
		ua.setEmployee(createEmployee(rs.nextString(),rs.nextString(),rs.nextString(),rs.nextString()));
		ua.setPermissions(list);
		ua.setUsername(rs.nextString());
		ua.setPassword(rs.nextString());
		
		return ua;
	}
	
	public Employee createEmployee(String email, String phone, String fn, String ln){
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setFirstName(fn);
		emp.setLastName(ln);
		return emp;
	}
}
