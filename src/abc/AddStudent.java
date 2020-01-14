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

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentModel> data = new ArrayList<>();
		data = StudentDAO.getAllData();
		//System.out.println(data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("student",data);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usn = request.getParameter("usn");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String colg = request.getParameter("colg");
		StudentModel student = new StudentModel();
		student.setUsn(usn);
		student.setName(name);
		student.setDept(dept);
		student.setColg(colg);
		System.out.println(student);
		int result = StudentDAO.addStudent(student);
		if(result!=0) {
			response.sendRedirect("Student.jsp");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Student.jsp");
			request.setAttribute("status", "Error while Inserting! Kindly Try again");
			dispatcher.forward(request, response);
		}
		
	}

}
