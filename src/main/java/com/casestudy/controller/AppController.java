package com.casestudy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.casestudy.model.Order;
import com.casestudy.model.Product;
import com.casestudy.service.ProductService;
import com.casestudy.service.UserService;


@Controller
@RequestMapping("/")
@EnableWebMvc
public class AppController {
	@Autowired
	ProductService service;
	
	@Autowired
	UserService userService;
	
//	@RequestMapping(value = {"/static/html/login2"}, 
//			method = RequestMethod.POST)
//	public String login(ModelMap model){
//		return "redirect:/static/html/books.html";
//	}
	
//	@RequestMapping(value = {"/static/html/login2"}, 
//			method = RequestMethod.GET)
//	public String login2(ModelMap model){
//		return "redirect:/static/html/login2.html";
//	}
	
	@RequestMapping(value = {"/{url}"}, 
				method = RequestMethod.GET)
	public String listProducts(@PathVariable("url") String url,ModelMap model){
		System.out.println(getPrincipal());
		return "redirect:/static/html/"+url+".html";
	}
	
	@RequestMapping(value = {"/home/filter"}, 
			method = RequestMethod.GET)
	public String listProductsWithFilter(HttpServletRequest request, 
							HttpServletResponse response,ModelMap model){
		return "redirect:/static/html/home.html?filterValue="+request.getParameter("filterValue");
	}
	
	
	@RequestMapping(value = {"/product/{productId}"}, 
			method = RequestMethod.GET)
	public String showProduct(@PathVariable("productId") String productId,ModelMap model){
//		System.out.println(getPrincipal());
		return "redirect:/static/html/product.html?productId="+productId;
	}
	
	
	
	@RequestMapping(value = {"/json/{name}"}, produces = "application/json", 
			method = RequestMethod.GET)
	public @ResponseBody List<Product> jsonListProductsByCategory(@PathVariable("name") String name,
					ModelMap model){
		if(name.equals("home")){
			return service.listAllProducts();
		}
		else{
			return service.listProductsByCategory(name);
		}
	}
	
	@RequestMapping(value = {"/json/home/{name}"}, produces = "application/json", 
			method = RequestMethod.GET)
	public @ResponseBody List<Product> filterHome(@PathVariable("name") String name,
					ModelMap model){
		int filterId = Integer.parseInt(name);
		
		return service.productHomePriceFilter(filterId);
	}
	
	@RequestMapping(value = {"/json/product/{productId}"}, produces = "application/json", 
			method = RequestMethod.GET)
	public @ResponseBody Product getProductInfo(@PathVariable("productId")String  productId,
					ModelMap model){
			long longProductId = Integer.parseInt(productId);
			return service.findById(longProductId);
	
	}
	
	@RequestMapping(value="/user/cart/{productId}", method = RequestMethod.GET)
    public String addProductToCart (@PathVariable("productId")String  productId,
			ModelMap model) {
		long longProductId = Integer.parseInt(productId);
		userService.addProductToCart(getPrincipal(), longProductId);
		return "redirect:/static/html/"+"cart"+".html";
    }
	
	@RequestMapping(value="/user/json/cart", method = RequestMethod.GET)
    public @ResponseBody List<Order> showCartJson (ModelMap model) {
		
		return userService.getAllCartOrders(getPrincipal());
    }
	
	  @RequestMapping(value="/user/logout", method = RequestMethod.GET)
      public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
         }
         return "redirect:/static/html/"+"logout"+".html";
      }
	  
	  private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	
}
