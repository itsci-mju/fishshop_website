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

import org.itsci.fishshop.dao.NewsManager;
import org.itsci.fishshop.dao.ProductManager;
import org.itsci.fishshop.model.News;
import org.itsci.fishshop.model.Register;

@Controller
public class NewsController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		@RequestMapping(value = "/LoadAddNews", method = RequestMethod.GET)
		public String loadAddProductPage() {
			return "AddNews";
		}

		@RequestMapping(value = "/LoadAddNews", method = RequestMethod.POST)
		public ModelAndView doAddNews(HttpServletRequest request) {
			String message = "";
			NewsManager ng = new NewsManager(); 
			int NID = ng.getMaxNewsID();
			String NewsID = String.valueOf(NID);
			System.out.println(NID);
			System.out.println(NewsID);
			ModelAndView mav = new ModelAndView("AddNews");
			if (ServletFileUpload.isMultipartContent(request)) {
				try { 
					List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					String NewsPic =   new File(data.get(0).getName()).getName();
					String NewsName = new String(data.get(1).get(),StandardCharsets.UTF_8);
					String NewsDetail = new String(data.get(2).get(),StandardCharsets.UTF_8);
					String mid =  data.get(3).getString();
					Register res = new Register();
					News pd = new News(NID,NewsPic,NewsName,NewsDetail,res);
					NewsManager pm = new NewsManager();
					message = pm.AddNews(pd,NewsID);
					String path = request.getSession().getServletContext().getRealPath("/") + "\\img";
					data.get(0).write(new File(path + File.separator + NewsPic));
				} catch (Exception e) {
					e.printStackTrace();
					message = "Please try again....";
				}
			}

			mav.addObject("message", message);
			return mav;
		}
		
		@RequestMapping(value="/SearchNews", method=RequestMethod.GET)
		public String loadSearch() {
			return "searchNews";
		}
		
		@RequestMapping(value="/SearchNews", method=RequestMethod.POST)
		public String getSearchProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String Nname= request.getParameter("search");
		NewsManager pm = new NewsManager();
		List<News> list = new ArrayList<>();
		list = pm.searchNews(Nname);
		request.setAttribute("result", list);
		return "searchNews";
	}
		
		
		@RequestMapping(value="/loadEditNews", method=RequestMethod.GET)
		public String loadEditProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
			String NewsID = request.getParameter("nid");
			NewsManager pm = new NewsManager();
			List<News> list = new ArrayList<>();
			list = pm.getNews(NewsID);
			request.setAttribute("result", list);
			return "EditNews";
		}

		@RequestMapping(value="/loadEditNews", method=RequestMethod.POST)
		public String getEditNews(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
			request.setCharacterEncoding("UTF-8");
			String NewsID = request.getParameter("NewsID");
			String NewsPic = request.getParameter("NewsPic");
			String NewsName = request.getParameter("NewsName");
			String NewsDetail = request.getParameter("NewsDetail");
			NewsManager sm = new NewsManager();
			int r = sm.EditNews(NewsID,NewsPic,NewsName,NewsDetail);
			request.setAttribute("editresult", r);
			
			String nid = request.getParameter("nid");
			NewsManager pm = new NewsManager();
			List<News> list = pm.searchNews(nid);
			request.setAttribute("result", list);
			
		return "index";
	}
		@RequestMapping(value="/DeleteNews", method=RequestMethod.GET)
		public String getDelectProduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
		String proid = request.getParameter("proid");
		ProductManager sm = new ProductManager();
		int r = sm.deleteProduct(proid);
		request.setAttribute("delresult", r);
		return "index";
	}
		
		@RequestMapping(value="/loadAllNews", method=RequestMethod.GET)
		public String getAllproduct(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		NewsManager pm = new NewsManager();
		List<News> list = new ArrayList<>();
		list = pm.getAllNews();
		request.setAttribute("resultNews", list);
		return "ShowNews";
	}
		
}


