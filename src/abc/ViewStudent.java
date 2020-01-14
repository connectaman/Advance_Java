package abc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentModel> data = new ArrayList<>();
		data = StudentDAO.getAllData();
		//System.out.println(data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		request.setAttribute("student",data);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		List<StudentModel> data = new ArrayList<>();
		data = StudentDAO.search(search);
		//System.out.println(data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		request.setAttribute("student",data);
		dispatcher.forward(request, response);
	}
	
	
	
	
	


}
