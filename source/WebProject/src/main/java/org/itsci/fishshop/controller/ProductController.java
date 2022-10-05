package org.itsci.fishshop.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.itsci.fishshop.dao.ProductManager;
import org.itsci.fishshop.model.Categories;
import org.itsci.fishshop.model.Product;


@Controller
public class ProductController {
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

		@RequestMapping(value = "/LoadAddProduct", method = RequestMethod.GET)
		public String loadAddProductPage() {
			return "AddProduct";
		}

		@RequestMapping(value = "/LoadAddProduct", method = RequestMethod.POST)
		public ModelAndView doAddProduct(HttpServletRequest request) {
			String message = "";
			ProductManager pg = new ProductManager(); 
			int PID = pg.getMaxProductID();
			String ProductID = String.valueOf(PID);
			System.out.println(PID);
			System.out.println(ProductID);
			ModelAndView mav = new ModelAndView("AddProduct");
			if (ServletFileUpload.isMultipartContent(request)) {
				try { 
					List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					String ProductPic = new File(data.get(0).getName()).getName();   
					String ProductName = new String(data.get(1).get(),StandardCharsets.UTF_8);
					String amount = data.get(2).getString();
					String unit =  data.get(3).getString();
					String Price = data.get(4).getString();
					String ctid = data.get(5).getString();
					Categories ct = new Categories(ctid,"");
					Product pd = new Product(PID,ProductPic,ProductName,amount,unit,Price,ct);
					ProductManager pm = new ProductManager();
					message = pm.AddProduct(pd,ProductID);
					String path = request.getSession().getServletContext().getRealPath("/") + "\\img";
					data.get(0).write(new File(path + File.separator + ProductPic));
				} catch (Exception e) {
					e.printStackTrace();
					message = "Please try again....";
				}
			}

			mav.addObject("message", message);
			return mav;
		}
		
		 /*@PostMapping("/LoadAddProduct")
		public ModelAndView doAddProduct(@RequestParam("ProductPic") MultipartFile multipartFile,
				@RequestParam("ProductName") String ProductName,
				@RequestParam("amount") String amount,
				@RequestParam("unit") String unit,
				@RequestParam("price") String price
		) throws IOException { 
			String message = "";
			ProductManager pg = new ProductManager(); 
			int PID = pg.getMaxProductID();
			String ProductID = String.valueOf(PID);
			System.out.println(PID);
			System.out.println(ProductID);
			ModelAndView mav = new ModelAndView("AddProduct");
				try { 
					RequestAttributes requestAttributes = RequestContextHolder
				            .currentRequestAttributes();
				    ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
				    HttpServletRequest request = attributes.getRequest();
					String path = request.getSession(true).getServletContext().getRealPath("/img") + "Fish-photos/"+PID;
					String path =  "Fish-photos/"+PID;
					String fileName = multipartFile.getOriginalFilename();
					String ProductImages = path+"/"+fileName;
					Product pd = new Product(PID,ProductImages,ProductName,amount,unit,price);
					ProductManager pm = new ProductManager();
					message = pm.AddProduct(pd,ProductID);
				        FileUploadUtil.saveFile(path, fileName, multipartFile);
				} catch (Exception e) {
					e.printStackTrace();
					message = "Please try again....";
				}
			

			mav.addObject("message", message);
			return mav;
		}*/
		
	@RequestMapping(value="/SearchProduct", method=RequestMethod.GET)
	public String loadSearch() {
		return "SearchProduct";
	}
	
	@RequestMapping(value="/SearchProduct", method=RequestMethod.POST)
	public String getSearchProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
	request.setCharacterEncoding("UTF-8");
	String pname= request.getParameter("search");
	ProductManager pm = new ProductManager();
	List<Product> list = new ArrayList<>();
	list = pm.searchProduct(pname);
	request.setAttribute("result", list);
	return "SearchProduct";
}
	
	@RequestMapping(value="/loadEditProduct", method=RequestMethod.GET)
	public String loadEditProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		String pid= request.getParameter("proid");
		ProductManager pm = new ProductManager();
		List<Product> list = new ArrayList<>();
		list = pm.getProduct(pid);
		request.setAttribute("result", list);
		return "EditProduct";
}

	@RequestMapping(value="/loadEditProduct", method=RequestMethod.POST)
	public String getEditProduct(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String ProductID = request.getParameter("ProductID");
		String ProductPic = request.getParameter("ProductPic");
		String ProductName = request.getParameter("ProductName");
		String amount = request.getParameter("Amount");
		String unit = request.getParameter("Unit");
		String price = request.getParameter("Price");
		ProductManager sm = new ProductManager();
		int r = sm.EditProduct(ProductID,ProductPic,ProductName,amount,unit,price);
		request.setAttribute("editresult", r);
		
		String proid = request.getParameter("proid");
		ProductManager pm = new ProductManager();
		List<Product> list = pm.getProduct(proid);
		request.setAttribute("result", list);
		
	return "index";
}
	@RequestMapping(value="/DeleteProduct", method=RequestMethod.GET)
	public String getDelectProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
	String proid = request.getParameter("proid");
	ProductManager sm = new ProductManager();
	int r = sm.deleteProduct(proid);
	request.setAttribute("delresult", r);
	return "index";

}
	
	@RequestMapping(value="/loadProduct", method=RequestMethod.POST)
	public String getproductdetail(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
	request.setCharacterEncoding("UTF-8");
	String pname = request.getParameter("ProductID");
	ProductManager pm = new ProductManager();
	List<Product> list = new ArrayList<>();
	list = pm.getProduct(pname);
	request.setAttribute("result", list);
	return "index";
}
	
	@RequestMapping(value="/loadAllProduct", method=RequestMethod.GET)
	public String getAllproduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
	request.setCharacterEncoding("UTF-8");
	ProductManager pm = new ProductManager();
	List<Product> list = new ArrayList<>();
	list = pm.getAllproduct();
	request.setAttribute("resultProduct", list);
	return "ShowProduct";
}
	
	@RequestMapping(value="/loadProductDetail", method=RequestMethod.GET)
	public String loadProductDetail(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		String pid= request.getParameter("proid");
		ProductManager pm = new ProductManager();
		List<Product> list = new ArrayList<>();
		list = pm.getProduct(pid);
		request.setAttribute("result", list);
		return "ProductDetail";
}
	
	
	
}

