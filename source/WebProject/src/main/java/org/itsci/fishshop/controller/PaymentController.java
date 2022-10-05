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
public class PaymentController {

	@RequestMapping(value="/payment", method=RequestMethod.GET)
    public String loadpayment() {
        return "payment";
    }
	
	@RequestMapping(value = "/LoadPayment", method = RequestMethod.POST)
	public ModelAndView doAddProduct(HttpServletRequest request) {
		String message = "";
		ProductManager pg = new ProductManager(); 
		int PAID = pg.getMaxProductID();
		String ProductID = String.valueOf(PAID);
		System.out.println(PAID);
		System.out.println(ProductID);
		ModelAndView mav = new ModelAndView("AddPayment");
		if (ServletFileUpload.isMultipartContent(request)) {
			try { 
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String PaymentPic = new String(data.get(0).get(),StandardCharsets.UTF_8);
				String TimesPayment = data.get(1).getString();
				String PaymentName =  data.get(2).getString();
				Payment pem = new Payment(PAID,PaymentPic,TimesPayment,PaymentName);
				PaymentManager pm = new PaymentManager();
				message = pm.AddPayment(pem, PaymentName);
				String path = request.getSession().getServletContext().getRealPath("/") + "\\img";
				data.get(0).write(new File(path + File.separator + PaymentPic));
			} catch (Exception e) {
				e.printStackTrace();
				message = "Please try again....";
			}
		}

		mav.addObject("message", message);
		return mav;
	}
		
	
	public PaymentController() {
		// TODO Auto-generated constructor stub
	}

}
