package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);

	List<Product> getProductsByCategory(String category);

	void addProduct(Product product);

	Product get(long id);

	List<Product> getProductsByDescOrder();
}