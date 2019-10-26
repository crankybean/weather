package au.usyd.elec5619.service;

import java.util.List;
import java.io.Serializable;

import au.usyd.elec5619.domain.Product;

public class SimpleProductManager implements ProductManager{
	
	private List<Product> products;
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void increasePrice(int percentage) {
		if (products != null) {
			for(Product product : products) {
				double newPrice = product.getPrice().doubleValue()*
						(100+percentage)/100;
				product.setPrice(newPrice);
			}
		}
	}
	
public void addProduct(Product product) {
		
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Product getProductById(long id) {
		return null;
	}
	
	@Override
	public void updateProduct(Product product) {
		
	}
	
	@Override
	public void deleteProduct(long id) {
		
	}
}
