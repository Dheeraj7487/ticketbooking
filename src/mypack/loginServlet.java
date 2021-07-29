package mypack;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class loginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
	try {
	 res.setContentType("text/html");
	 PrintWriter out=res.getWriter();
	 
	String username= req.getParameter("username").trim();
	String userpass= req.getParameter("userpass").trim();
	
	String url = "jdbc:mysql://localhost/ticket_booking";
	String user = "root";
	String pass = "";
	
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,pass);
		
		String sql="select * from signin where username='"+username+"'";
		
		 Statement stmt=conn.createStatement();
         
         ResultSet rs=stmt.executeQuery(sql);

         while(rs.next())
         {
          String Uname = rs.getString("username");
          String UPass = rs.getString("password");
	
	
    if(username.equals(Uname) && userpass.equals(UPass)) 
	{
		HttpSession session=req.getSession();
		session.setAttribute("userName",username);
		session.setAttribute("userPass",userpass);
		res.sendRedirect("dashboard.html");
		out.close();
		
	}
    
	else {
		out.print("Wrong Credential");
		RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
		rd.include(req, res);
	}
         }
	}
	catch(Exception ex)
	{
		System.out.println("Exception caught"+ex);
	}
 }
	
}
