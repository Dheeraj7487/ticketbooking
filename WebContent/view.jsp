<%@ page import = "java.util.*, java.sql.* " %>

<html>
<body>
<% 
response.setContentType("text/html");
String name=request.getParameter("name");
String mobile=request.getParameter("phone");
String city=request.getParameter("city");
String theatre=request.getParameter("theatre");
String movie=request.getParameter("movie");
String seat1=request.getParameter("seat1");
String seat1_book=request.getParameter("seat1_book");
String seat2=request.getParameter("seat2");
String seat2_book=request.getParameter("seat2_book");
String date=request.getParameter("date");

try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ticket_booking", "root", ""); 

	String sql="insert into dashboard values('"+name+"','"+mobile+"','"+city+"','"+theatre+"','"+movie+"','"+seat1+"','"+seat1_book+"','"+seat2+"','"+seat2_book+"','"+date+"')";

	Statement stmt = conn.createStatement();
	int n=stmt.executeUpdate(sql); 
	if (n == 1)
	{
    	System.out.println("Booking successfully : "+sql); 
    	response.sendRedirect("Payments.html");
	}
    else
    {
    	System.out.println("Booking failed"); 
    }

}
catch(Exception ex){
	System.out.println(ex);
}

%>
</body>
</html>