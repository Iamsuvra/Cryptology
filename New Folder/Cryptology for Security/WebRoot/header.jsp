<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  
  <body>
  
  <table>
          <tr>        
                 
				<td align="center" colspan="1" width="900" height="120">
				
				<img src=<%=request.getContextPath()+"/images/img20.jpeg"%>  height="130" width="800"/>
				
				</td>
				<tr>
				<tr>        
                 
				<td align="center" colspan="1" width="900" >
				
				<img src=<%=request.getContextPath()+"/images/img11.jpg"%> height="10" width="800"/>
				
				</td>
				<tr>
				
				<tr><td>
				<c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
   				<jsp:include page="Adminmenu.jsp"/>
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role=='user'}">
   				<jsp:include page="Usermenu.jsp"/>
   				</c:when>
   
			     <c:otherwise>
						<jsp:include page="menubeforelogin.jsp"/>
					</c:otherwise>
					</c:choose>
					</c:if>
					</td>
					</tr>
				</table>
 </body>
 </html>