package au.usyd.elec5619.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.SimpleUserManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class UserInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	static private ModelAndView mav= new ModelAndView("register");
	@Resource(name="userManager")
	private SimpleUserManager userManager;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/passChange", method=RequestMethod.POST)
	public String changePass(HttpServletRequest httpServletRequest) {
		String userName = httpServletRequest.getParameter("username");
		String oldPassword = httpServletRequest.getParameter("password");
		String newPassword = httpServletRequest.getParameter("npassword");
		String conPassword = httpServletRequest.getParameter("cpassword");
		User user = userManager.getUserByUserName(userName);
		
		user.setPassword(conPassword);
		userManager.updateUser(user);
		
		return "home";
	}
	
}
