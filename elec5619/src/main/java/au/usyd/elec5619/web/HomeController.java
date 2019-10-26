package au.usyd.elec5619.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home/**", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest httpServletRequest) {
		String userName = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		String email = httpServletRequest.getParameter("email");
		String gender = httpServletRequest.getParameter("gender");
		if (gender.toLowerCase()!="male"||gender.toLowerCase()!="female") {
			gender="male";
		}
		
		
		
		return new ModelAndView();
	}
	
}
