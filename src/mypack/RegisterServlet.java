package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("name");
		String phone=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String cnfpassword=req.getParameter("cnfpassword");
		
	
		if(!password.equals(cnfpassword)) {
			out.print("<p style=color:#fff;text-align:center;>Please Match the password and Confirm password </p>");
			RequestDispatcher rd=req.getRequestDispatcher("/Sign%20Up.html");
			rd.include(req, res);
	
		}
		else 
		{
			try {
			String url = "jdbc:mysql://localhost/ticket_booking";
			String user = "root";
			String pass = "";
			String sql="insert into signup values('"+uname+"','"+phone+"','"+email+"','"+password+"','"+cnfpassword+"')";
			String insert="insert into signin values('"+uname+"','"+password+"')";
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection(url,user,pass);
		    
				Statement stmt=conn.createStatement();
				int m = stmt.executeUpdate(sql); 
				
				if (m == 1) 
            	System.out.println("Register successfully : "+sql); 
            else
            	System.out.println("Register failed"); 

				int n = stmt.executeUpdate(insert); 
				
				if (n == 1) 
            	System.out.println("Login detail save successfully : "+insert); 
            else
            	System.out.println("Save failed"); 

				
			out.print("<p>Registration Completed ");
			out.println("click below to Login <br>");
			out.print("<a href='Login.html'> click here for login </a></p>");
			out.close();
			}
			catch(Exception ex)
			{System.out.println("Exception caught"+ex);}
			
			
		}
		
	}
}
