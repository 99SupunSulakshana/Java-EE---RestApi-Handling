<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	   List<String> itemname = (List) session.getAttribute("ItemName");
	   List<Integer> itemqty = (List) session.getAttribute("ItemQty");
	   List<Double> itemtotalamt = (List)session.getAttribute("ItemTotalAmt");
	   double billamt =(double)session.getAttribute("TotalAmount");
	   
	   int size = itemname.size();
	   
	  
	%>
	
	  <h1>Bill Details</h1>
	  <h3>Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  		Quantity &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  		Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  		
	  </h3>
	  <table>
	  <%
	    for(int count = 0; count < size; count++)
	    {
	    	out.print("<tr>");
	    	out.print("<td>");
	    	out.print(itemname.get(count));
	    	out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	    	out.print("</td>");
	    	out.print("<td>");
	    	out.print(itemqty.get(count));
	    	out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	    	out.print("</td>");
	    	out.print("<td>");
	    	out.print(itemtotalamt.get(count));
	    	out.print("</td>");
	    	out.print("</tr>");
	    }
	  
	  %>
	  </table>
	  
	  <%
	  out.print("Bill Amount :" + billamt);
	  %>
</body>
</html>