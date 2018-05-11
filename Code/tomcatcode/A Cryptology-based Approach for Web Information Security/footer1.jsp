<html>
	<body>
		<center>

			 <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%>



		</center>





	</body>
</html>
