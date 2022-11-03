package org.itsci.fishshop.controller;

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

import org.itsci.fishshop.dao.AddressManager;
import org.itsci.fishshop.model.Register;
import org.itsci.fishshop.model.Address;


@Controller
public class AddressController {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Controller
    public class AddProductController {
        @RequestMapping(value = "/LoadAddress", method = RequestMethod.GET)
        public String loadRegisterPage() {
            return "Address";
        }

        @RequestMapping(value = "/LoadisAddress", method = RequestMethod.POST)
        public ModelAndView doAddRegister(HttpServletRequest request) {
            String message = "";
            AddressManager pm = new AddressManager();
            int AID = pm.getMaxAddressID();
            String AddressID = String.valueOf(AID);
            System.out.println(AID);
            System.out.println(AddressID);
            ModelAndView mav = new ModelAndView("Payment");
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    String TrackNo = new String(data.get(0).get(), StandardCharsets.UTF_8);
                    String Street = new String(data.get(1).get(), StandardCharsets.UTF_8);
                    String SubDistrict = new String(data.get(2).get(), StandardCharsets.UTF_8);
                    String District = new String(data.get(3).get(), StandardCharsets.UTF_8);
                    String Province = new String(data.get(4).get(), StandardCharsets.UTF_8);
                    String ZipCode = new String(data.get(5).get(), StandardCharsets.UTF_8);
                    String TelNo = new String(data.get(6).get(), StandardCharsets.UTF_8);
                    String Email = request.getParameter("Email");
                    Register res = new Register();
                    res = pm.Register(Email);
                    Address rs = new Address(AID, TrackNo, Street, SubDistrict, District, Province, ZipCode, TelNo, res);
                    message = pm.insertAddreess(rs);
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
}