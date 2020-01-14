package abc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBack")
public class UpdateBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usn = request.getParameter("usn");
		String name =  request.getParameter("name");
		String dept =  request.getParameter("dept");
		String colg =  request.getParameter("colg");
		StudentModel data = new StudentModel();
		data.setUsn(usn);
		data.setName(name);
		data.setDept(dept);
		data.setColg(colg);
		System.out.println(data);
		boolean result = StudentDAO.update(data);
		if(result) {
			response.sendRedirect("ViewStudent");
		}else {
			System.out.println("ERROR");
		}
		
		
	}

}
