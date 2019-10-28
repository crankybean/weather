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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	static private ModelAndView mav= new ModelAndView("register");
	@Resource(name="userManager")
	private SimpleUserManager userManager;
	
	private User loginUser = null;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/register")
	public String addUser(Model uiModel) {
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest httpServletRequest) {
		String userName = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		String email = httpServletRequest.getParameter("email");
		String gender = httpServletRequest.getParameter("gender");
		if (gender.toLowerCase()!="male"||gender.toLowerCase()!="female") {
			gender="male";
		}
		
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		
		this.userManager.addUser(user);
		
		
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest httpServletRequest) {
		String userName = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		int suc = userManager.checkLogin(userName, password);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		
		if(suc==0) {
			myModel.put("success", userName);
			loginUser = new User();
			loginUser = userManager.getUserByUserName(userName);
			myModel.put("email", loginUser.getEmail());
			myModel.put("gender", loginUser.getGender());
			return new ModelAndView("loggedin","user",myModel);
		}
		else {
			myModel.put("fail", userName);
			return new ModelAndView("fail","model",myModel);
		}
		//new ModelAndView("home", "model", myModel);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		loginUser = null;
		return "home";
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(HttpServletRequest request, HttpServletResponse response) {
		return "passwordchange";
	}
	
	@RequestMapping(value = "/outfit", method = RequestMethod.GET)
	public ModelAndView selectOutfit(HttpServletRequest httpServletRequest){
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("gender", "hello");
		return new ModelAndView("whattowear","model",myModel);
	}
	
//	public ModelAndView showProfile(HttpServletRequest request, HttpServletResponse response) {
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		myModel.put("username", loginUser.getUserName());
//		myModel.put("email", loginUser.getEmail());
//		myModel.put("gender", loginUser.getGender());
//		return new ModelAndView("loggedin","model",myModel);
//	}
}
