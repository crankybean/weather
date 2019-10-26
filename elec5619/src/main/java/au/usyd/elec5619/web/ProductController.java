package au.usyd.elec5619.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;

@Controller
@RequestMapping(value="/product/**")
public class ProductController {
	
	@Resource(name="productManager")
	private ProductManager productManager;
	
	@RequestMapping(value="/add")
	public String addProduct(Model uiModel) {
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		Product product = new Product();
		product.setDescription(httpServletRequest.getParameter("description"));
		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		this.productManager.addProduct(product);
		
		return "redirect:/hello.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id) {
		this.productManager.deleteProduct(id);
		return "redirect:/hello.htm";
	}
}
