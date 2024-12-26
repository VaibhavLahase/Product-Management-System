package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.Product;
import com.tka.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping("/index")
    public String index() {
        return "index"; // Returns the JSP file `index.jsp`
    }

	@GetMapping("/add-product")
	public String insertProductPage() {
		return "add";
	}

	@PostMapping("/insert-product")
	public String addProduct(@ModelAttribute Product product) {
		System.out.println("We are in Post Method");
		System.out.println(product);
		String msg = productservice.addProduct(product);
		System.out.println(msg);
		return "add";
	}
	
	@GetMapping("/display-product")
	public String displayProduct(Model model) {
		System.out.println("we are in display-product method controller");
		 List<Product> list= productservice.displayProduct();
		System.out.println(list);
		model.addAttribute("products",list);
		 return "display";
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam("pid") int pk) {
		System.out.println(pk);
		System.out.println("we are in deleteproduct method of controller");
		String res = productservice.deleteProduct(pk);
		System.out.println(res);
		return "redirect:/display-product";
	}
	@GetMapping("/view-product")
	public String viewProduct(@RequestParam("pid") int pk, Model model) {
		Product product = productservice.getProduct(pk);
		model.addAttribute("p",product);
		return "update";
	}
	
	@PostMapping("/update-product")
	public String updateProduct(@ModelAttribute Product product) {
		
		String msg = productservice.updateProduct(product);
		
		return "redirect:/display-product";
	}
}
