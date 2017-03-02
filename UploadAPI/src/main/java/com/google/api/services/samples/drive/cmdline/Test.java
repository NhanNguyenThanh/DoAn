package com.google.api.services.samples.drive.cmdline;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.util.StringUtil;

import com.google.api.client.http.MultipartContent.Part;

/**
 * Servlet implementation class Test
 */
//@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("upfile");
		s = s.replace("\\", "/");
		
		DriveSample.excuteUploadFile(s);

			// TODO Auto-generated catch block
		
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		out.println(s);
		out.println("	</body>");
		out.println("</html>");
	}
	
//	private static String extractFileName(Part part) {
//	       String contentDisp = part.getHeader("content-disposition");
//	       String[] items = contentDisp.split(";");
//	       for (String s : items) {
//	           if (s.trim().startsWith("filename")) {
//	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
//	               clientFileName = clientFileName.replace("\\", "/");
//	               int i = clientFileName.lastIndexOf('/');
//	               return clientFileName;
//	           }
//	       }
//	       return null;
//	   }
}
