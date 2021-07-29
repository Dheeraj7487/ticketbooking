<%@ page import = "java.util.*, java.sql.* " %>
<html>
<body>
<% 
response.setContentType("text/html");
String cardnumber = request.getParameter("cardnumber");
String cardname = request.getParameter("cardname");
String expirydate = request.getParameter("expirydate");
String cvv = request.getParameter("cvv");

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ticket_booking", "root", ""); 

	String sql="insert into payment values('"+cardnumber+"','"+cardname+"','"+expirydate+"','"+cvv+"')";
	Statement stmt = conn.createStatement();
	int n=stmt.executeUpdate(sql); 
	if (n == 1)
	{
    	System.out.println("Payment successfully your ticket is booking : "+sql);
	    out.println("Your ticket Booking is successfully<br>");
	}
    else
    {
    	System.out.println("Payment failed"); 
    }


}

catch(Exception ex){
	System.out.println(ex);
}

%>
</body>
</html>