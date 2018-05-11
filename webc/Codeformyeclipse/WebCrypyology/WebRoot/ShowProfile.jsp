<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	  	
<jsp:include page="header.jsp"></jsp:include>
                   
<table>	
<tr>
<td><jsp:include page="header1.jsp"></jsp:include>
</td>
</tr>
<tr><td align="center"><h3><font color="Hblue"><b><i>View All User Details</i></b></font></h3></td></tr>
   
  
      
      <input type="hidden" name="type" value="projcode"/>
      <input type="hidden" name="value" value="<%=request.getParameter("projcode")%>"/>
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
     
      
       
       
     
       
	   <tr bgcolor="#asHblue">
 
       <td width="87"><div align="center" class="style8"><b>UserName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
        
        
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
     
        <td width="64"><div align="center" class="style8"><b>Registerd Date</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>Photo</b></div></td>
         <td width="64"><div align="center" class="style8"><b>Phoneno</b></div></td>
      </tr>
      
      <c:if test="${not empty profile}">
      <c:forEach var="FacultyInfo" items="${profile}">
       
      <tr bgcolor="#CEC9FA" >
    
       
        <td bgcolor="#F4F5F7" ><div align="center" class="style7"> ${FacultyInfo.name }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${FacultyInfo.fname }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${FacultyInfo.lname }</span></div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${FacultyInfo.dob }</span></div></td>
         
        
        
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${FacultyInfo.ldate }</div></td>
       
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="${FacultyInfo.photo }" height="50" width="90"></p></td>
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${FacultyInfo.phno }</div></td> 
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty FacultyInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong></strong></div></td>
         </tr>
    
         </c:if>
 </table><tr>
<td><jsp:include page="header1.jsp"></jsp:include>
</td>
</tr>
 </table>	
 
 
 <br/><br/> <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
