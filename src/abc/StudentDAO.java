package abc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public static int addStudent(StudentModel s) {
		int result = 0;
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	            PreparedStatement pst = con.prepareStatement("insert into niit.student values(?,?,?,?)");
	            pst.setString(1,s.getUsn());
	            pst.setString(2,s.getName());
	            pst.setString(3,s.getDept());
	            pst.setString(4,s.getColg());
	           result = pst.executeUpdate();
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		return result;
	}
	
	public static List<StudentModel> getAllData(){
		List<StudentModel> data = new ArrayList<StudentModel>();
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	            Statement smt = con.createStatement();
	            ResultSet rs = smt.executeQuery("Select * from niit.student");
	            while(rs.next()) {
	            	StudentModel s = new StudentModel();
	            	s.setUsn(rs.getString("id"));
	            	s.setName(rs.getString("name"));
	            	s.setDept(rs.getString("dept"));
	            	s.setColg(rs.getString("colg"));
	            	data.add(s);
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		return data;
	}
	
	public static StudentModel getAllData(String usn){
		StudentModel s = new StudentModel();
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	            Statement smt = con.createStatement();
	            ResultSet rs = smt.executeQuery("Select * from niit.student where id='"+usn+"'");
	            while(rs.next()) {
	            	s.setUsn(rs.getString("id"));
	            	s.setName(rs.getString("name"));
	            	s.setDept(rs.getString("dept"));
	            	s.setColg(rs.getString("colg"));
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		return s;
	}
	
	
	public static boolean update(StudentModel data) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	         PreparedStatement pst = con.prepareStatement("update niit.student set name=?,dept=?,colg=? where id=?");
	         pst.setString(1,data.getName());
	         pst.setString(2,data.getDept());
	         pst.setString(3,data.getColg());
	         pst.setString(4,data.getUsn());
	         int result = pst.executeUpdate();
	         if(result!=0) {
	        	 return true;
	         }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean delete(String usn) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	         PreparedStatement pst = con.prepareStatement("delete from niit.student where id=?");
	         pst.setString(1,usn);
	         int result = pst.executeUpdate();
	         if(result!=0) {
	        	 return true;
	         }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<StudentModel> search(String search){
		List<StudentModel> data = new ArrayList<StudentModel>();
		 try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niit","root","root");
	            Statement smt = con.createStatement();
	            ResultSet rs = smt.executeQuery("Select * from niit.student where name LIKE '%"+search+"%'");
	            while(rs.next()) {
	            	StudentModel s = new StudentModel();
	            	s.setUsn(rs.getString("id"));
	            	s.setName(rs.getString("name"));
	            	s.setDept(rs.getString("dept"));
	            	s.setColg(rs.getString("colg"));
	            	data.add(s);
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		return data;
	}

}
