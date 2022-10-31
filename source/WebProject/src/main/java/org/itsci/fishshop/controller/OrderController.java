package org.itsci.fishshop.controller;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.itsci.fishshop.model.Payment;
import org.itsci.fishshop.dao.PaymentManager;
import org.itsci.fishshop.dao.ProductManager;


@Controller
public class OrderController {

	@RequestMapping(value="/LoadOrder", method=RequestMethod.GET)
    public String loadpayment() {
        return "";
    }
	
	@RequestMapping(value = "/LoadOrder", method = RequestMethod.POST)
	public ModelAndView doOrder(HttpServletRequest request) {
		String message = "";
		ModelAndView mav = new ModelAndView("Order");
			try { 
				
				
			} catch (Exception e) {
				e.printStackTrace();
				message = "Please try again....";
			}
		

		mav.addObject("message", message);
		return mav;
	}
		
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}

}
