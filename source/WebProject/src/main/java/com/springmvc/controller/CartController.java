package com.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Cart;
import bean.Register;
import bean.Product;
import util.CartManager;
import util.ProductManager;

@Controller
public class CartController {
	
	@RequestMapping(value="/Cart", method=RequestMethod.GET)
    public String loadcart(HttpServletRequest request) {
		ProductManager pm = new ProductManager();
		String pname = request.getParameter("ProductID");
		List<Product> list = new ArrayList<>();
		list = pm.getProduct(pname);
		request.setAttribute("result", list);
		
        return "Cart";
    }

	@RequestMapping(value="/loadcart", method=RequestMethod.POST)
	public String getCart(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		CartManager  sm = new CartManager();
		int ct = sm.getMaxCartID();
		String Cartid = String.valueOf(ct);
		request.setCharacterEncoding("UTF-8");
	   Register lg = (Register) session.getAttribute("User"); 
	   
		String Email = lg.getEmail();
		String ProductID = request.getParameter("ProductID");
		String ProductName = request.getParameter("ProductName");
		String Quantity = request.getParameter("Quantity");
		String Price = request.getParameter("Price");
		
		int r = sm.insertCart(new Cart (Cartid,Email,ProductID,ProductName,Quantity,Price));
		request.setAttribute("result", r);
		
	return "Address";
}
	public CartController() {
		// TODO Auto-generated constructor stub
	}

}
