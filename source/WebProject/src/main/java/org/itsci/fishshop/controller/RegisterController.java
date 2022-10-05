package org.itsci.fishshop.controller;

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


import org.itsci.fishshop.dao.RegisterManager;
import org.itsci.fishshop.model.Register;



@Controller
public class RegisterController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		@Controller
		public class AddProductController {
			@RequestMapping(value = "/LoadAddRegister", method = RequestMethod.GET)
			public String loadRegisterPage() {
				return "Register";
			}

			@RequestMapping(value = "/LoadAddRegister", method = RequestMethod.POST)
			public ModelAndView doAddRegister(HttpServletRequest request) {
				String message = "";
				RegisterManager pg = new RegisterManager(); 
				int MID = pg.getMaxMemberID();
				String MemberID = String.valueOf(MID);
				System.out.println(MID);
				System.out.println(MemberID);
				ModelAndView mav = new ModelAndView("Register");
				if (ServletFileUpload.isMultipartContent(request)) {
					try { 
						List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
						String FristName =   new String(data.get(0).get(),StandardCharsets.UTF_8);  
						String LastName = new String(data.get(1).get(),StandardCharsets.UTF_8);
						String PhoneNo =  new String(data.get(2).get(),StandardCharsets.UTF_8);
						String Email =   new String(data.get(3).get(),StandardCharsets.UTF_8);
						String PassWord =  new String(data.get(4).get(),StandardCharsets.UTF_8);
						//String MemberType =  new String(data.get(5).get(),StandardCharsets.UTF_8);
						String mt = "User";
						Register rs = new Register(MID,FristName,LastName,PhoneNo,Email,PassWord,mt);
						RegisterManager pm = new RegisterManager();
						message = pm.AddRegister(rs,MemberID);
						//String path = request.getSession().getServletContext().getRealPath("/") + "\\images";
						//data.get(0).write(new File(path + File.separator + ProductPic));
					} catch (Exception e) {
						e.printStackTrace();
						message = "Please try again....";
					}
				}

				mav.addObject("message", message);
				return mav;
			}
			
	}
	
		@RequestMapping(value = "/loadEdit", method = RequestMethod.GET)
		public String loadEditPage(HttpServletRequest request, HttpSession session) {
			String memid = request.getParameter("User");

			RegisterManager km = new RegisterManager();
			List<Register> list = new ArrayList<>();
			list = km.getRegister(memid);
			request.setAttribute("getresult", list);
			return "EditProfilemember";
		}
		
		@RequestMapping(value = "/loadprofile", method = RequestMethod.GET)
		public String loadprofilePage() {
			return "Profile";
		}
		
		@RequestMapping(value="/loadEditRegister", method=RequestMethod.GET)
		public String getEditRegister(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
			request.setCharacterEncoding("UTF-8");
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String PhoneNo = request.getParameter("PhoneNo");
			String Email = request.getParameter("Email");
			String PassWord = request.getParameter("PassWord");
		
			Register m = new Register(0, FirstName,LastName,PhoneNo,Email,PassWord, PassWord);
			RegisterManager pm = new RegisterManager();
			int r = pm.EditRegister(m);
			session.setAttribute("User", m);	
			request.setAttribute("result", r);
			return "Profile";
	}

}
