package com.nagarro.imageutility.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.Part;

import org.hibernate.cfg.Configuration;

import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.models.RegisterDetail;
import com.nagarro.imageutility.services.DataManager;

/**
 * Servlet implementation class ImageMgmtServlet
 */
@MultipartConfig(maxFileSize = 1024 * 1024)
@WebServlet("/ImageMgmtServlet")
public class ImageMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageMgmtServlet() {
		super();
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part file = request.getPart("file");
		String filename = getFilename(file);
	
		InputStream filecontent = file.getInputStream();
		byte[] fileBytes = new byte[(int) file.getSize()];
		filecontent.read(fileBytes);
		filecontent.close();
		int userId=1;
		userId=Integer.parseInt(request.getParameter("userId"));
		
		ImageDetail imageDetails = new ImageDetail();
		imageDetails.setImageStream(fileBytes);
		imageDetails.setName(filename);
		imageDetails.setSize(round(file.getSize(),2));
		
		RegisterDetail registerDetails=new RegisterDetail();
		
		registerDetails=DataManager.getRegisterDetails(userId);
		
		imageDetails.setRegisterDetail(registerDetails);
		// imageDetails.setSize();
		//List<ImageDetail> checkSize=DataManager.getImageDetails();
		double totalSize=0.0;
		/*for(ImageDetail objImgDetail: checkSize){
			totalSize+=objImgDetail.getSize();
		}*/
		totalSize=DataManager.getTotalImgSize(userId);
		if(totalSize+imageDetails.getSize()<10.0){
			DataManager.insertImage(imageDetails);
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		/*
		 * response.getWriter().write("File " + filename + " successfully
		 * uploaded");
		 */ System.out.println("File " + filename + " successfully uploaded");
		// DataManager.getImg(response);
		  

	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value/(1024*1024));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); 
			}
		}
		return null;
	}

}
