package com.example.ecommerce.Ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Ecommerce.model.Cart;
import com.example.ecommerce.Ecommerce.model.Product;
import com.example.ecommerce.Ecommerce.repository.CartRepository;
import com.example.ecommerce.Ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void saveProducts(Product product) {
		productRepository.save(product);
	}

	public List<Product> loadCart(String userName) {
		List<Cart> cartList =	cartRepository.findByUsername(userName);
		List<Product> products = new ArrayList<Product>();
		if(cartList!=null && cartList.size()>0) {
			for(Cart cart : cartList) {
				Product product = productRepository.findById(cart.getProductid()).get();
				products.add(product);
			}
			return products;
		}
		return null;
	}
	
	public Cart addToCart(String productId,String userName) {
		Product product = productRepository.findById(Long.parseLong(productId)).get();
		Cart cart = new Cart();
		cart.setProductid(product.getId());
		cart.setUsername(userName);
		cart.setPrice(product.getPrice());
		cartRepository.save(cart);
		return cart;
	}
	
	public List<Product> removeFromCart(String userName,String productId) {
		cartRepository.deleteByUsernameAndProductid(userName,Long.parseLong(productId));
		return loadCart(userName);
	}
	

}
