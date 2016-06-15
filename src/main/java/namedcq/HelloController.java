package namedcq;

import namedcq.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class HelloController {
	
	@RequestMapping(value="/sayHello/{name}",method=RequestMethod.GET)
	public @ResponseBody String sayHello( @PathVariable String name ){
	
		return "Hi "+name;
	}
	@RequestMapping(value="/viewUser/{id}",method=RequestMethod.GET)
	public String viewUser(@PathVariable String id, Model model ){		
		User user = new User(id,id+ "name");
		model.addAttribute("user", user);
		return "viewUser"; // ส่งไป view
	}
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String id){
		User user = new User(id,id+ "name");
		return user;
	}

}
