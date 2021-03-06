package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping({ "", "/all" })
	public List<Product> list(Model model) {
		return productService.getAllProducts();

	}

	@RequestMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long productId) {
		return productService.get(productId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Product processAddNewProductForm(@RequestBody Product productToBeAdded) {
		productService.addProduct(productToBeAdded);
		return null;
	}
}