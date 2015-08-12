package nl.harmster.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nl.harmster.domain.Employee;
import nl.harmster.services.DataService;

@Controller
public class DataController {

	
 @Autowired
 DataService dataService;

 
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
 public ModelAndView editUser(@RequestParam int id,
   @ModelAttribute Employee employee) {
  Employee employeeObject = dataService.getRowById(id);
  return new ModelAndView("edit", "employeeObject", employeeObject);
 }

 @RequestMapping("update")
 public ModelAndView updateUser(@ModelAttribute Employee employee) {
  dataService.updateRow(employee);
  return new ModelAndView("redirect:list");
 }
 
 @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
 public String home(Locale locale, Model model) {
      
     Date date = new Date();
     DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
     String formattedDate = dateFormat.format(date);
      
     model.addAttribute("serverTime", formattedDate );
      
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

}
