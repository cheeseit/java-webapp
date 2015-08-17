package nl.harmster.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nl.harmster.domain.Employee;
import nl.harmster.domain.UserAccount;
import nl.harmster.services.AccountDataService;
import nl.harmster.services.DataService;

@Controller
public class DataController {

	final static Logger logger = Logger.getLogger(DataController.class);
	@Autowired
	DataService dataService;
	
	@Autowired
	AccountDataService accountDataService;

	@RequestMapping("form")
	public ModelAndView getForm(@ModelAttribute Employee employee) {
		return new ModelAndView("form");
	}

	@RequestMapping("register")
	public ModelAndView registerUser(@ModelAttribute Employee employee) {
		dataService.insertRow(employee);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("list")
	public ModelAndView getList() {
		List employeeList = dataService.getList();
		return new ModelAndView("list", "employeeList", employeeList);
	}

	@RequestMapping("delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("edit")
	public ModelAndView editUser(@RequestParam int id, @ModelAttribute Employee employee) {
		Employee employeeObject = dataService.getRowById(id);
		return new ModelAndView("edit", "employeeObject", employeeObject);
	}

	@RequestMapping("update")
	public ModelAndView updateUser(@ModelAttribute Employee employee) {
		dataService.updateRow(employee);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping(value = "populatedb", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView populateDatabase(@RequestParam(value = "button1", required = false) String button) {
		logger.debug("I am in.!!");
		if (button != null && !button.isEmpty()) {
			List<UserAccount> ual;
			
			nl.harmster.utility.database.DatabasePopulator dbp = new nl.harmster.utility.database.DatabasePopulator();
			Employee emp1 = dbp.populateDatabase();
			dataService.insertRow(emp1);
			ual = dbp.populateUserAccounts();
			for( Iterator<UserAccount> i = ual.iterator(); i.hasNext();){
				UserAccount item = i.next();
				accountDataService.createUserAccount(item);
			}
			logger.info("done inserting.");
		}
		return new ModelAndView("populatedb");
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

}
