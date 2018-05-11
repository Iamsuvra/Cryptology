<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    
  </head>  
  <jsp:include page="header.jsp" />
  <br/>
  <br/>
  <body>   
    <table>
    <table width="950" align="center"  background="images/background1.jpg">
     <tr>
      <td colspan="2" align="center">
       <jsp:include page="footer1.jsp"></jsp:include>
      </td>
     </tr>
     
    <tr>
     <td>
     <table align="center" border="1" width="500" height="116" bordercolor="#asHblue">
     <tr >
   
   <th align="left" width="100">From</th>
   <th align="left" width="100">To</th>
   <th align="left" width="100">Message</th>
    <th align="left" width="100">Attachment</th>
    <th align="left" width="100">Delete</th>
    <th align="left" width="100">Date_time</th>
    </tr>
     <c:forEach items="${requestScope.email}"   var="lp1">
     <tr>
    
   <td align="left" width="100"><c:out value="${lp1.from}"/></td>
   <td align="left" width="100"><c:out value="${lp1.to}"/></td>
   <td align="left" width="100"><c:out value="${lp1.msg}"/></td>
     
     <td align="left" width="100"><a href="./Test?mid=${lp1.msgno}" style="text-decoration: none">view</a> </td>
    <td align="left" width="100"><a href="./DeleteMail?mid=${lp1.msgno}" style="text-decoration: none">delete</a> </td>
    <td align="left" width="100"><c:out value="${lp1.date}"/></td>
   
    </tr> 
    </c:forEach> 
     
     </table> 
     <tr>
     <td>
     <jsp:include page="header1.jsp"></jsp:include>
     </td>
     </tr>
</table>
   
 </table> </body>
</html>
