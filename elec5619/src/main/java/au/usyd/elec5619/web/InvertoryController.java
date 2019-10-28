package au.usyd.elec5619.web;

import au.usyd.elec5619.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InvertoryController implements Controller {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	private ProductManager productManager;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now",now);
		myModel.put("products", this.productManager.getProducts());
		
		return new ModelAndView("hello", "model", myModel);
}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}