<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<%@ page import="com.wc.ProfileBean.LoginProfileBean,com.wc.action.*"%>
<%@ page import="com.wc.ProfileBean.AddressProfileBean"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>

		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>

		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js">


</script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
	</head>
	<jsp:include page="header.jsp" />
	<body>



		<%
			LoginProfileBean lp = new LoginProfileBean();
			AddressProfileBean ad = new AddressProfileBean();
			String name = (String) session.getAttribute("user");
			String path1 = request.getRealPath("/userimages");
			List list = new ArrayList();
			list = (List) request.getAttribute("list");
			lp = (LoginProfileBean) list.get(0);
			ad = (AddressProfileBean) list.get(1);
			list.get(1);
		%>
		<br />
		<p>
			<img align="right" alt="See Photo Here" id="previewField"
				src="<%=lp.getPhoto()%>" height="150" width="120">
		</p>
		<br />
		<table width="403" height="116" bordercolor="#FEE8B6" align="center">
			<tr>
				<strong><span class="Title1"><u>Personal Details<br />
							<br /> </u> </span> </strong>
			</tr>

			<tr bgcolor="#asHblue">
				<td width="128">
					<strong><span class="style14 Title">FirstName</span> </strong>
				</td>
				<td width="366" bgcolor="">
					<span class="Title1"><strong><%=lp.getFname()%></strong> </span>
				</td>
			</tr>
			<tr bgcolor="#asHblue">
				<td bgcolor=>
					<span class="Title1"><strong>LastName</strong> </span>
				</td>
				<td bgcolor=>
					<span class="Title1"><strong><%=lp.getLname()%></strong> </span>
				</td>
			</tr>
			<tr bgcolor="#asHblue">
				<td bgcolor=>
					<span class="Title1"><strong>Dob</strong> </span>
				</td>
				<td bgcolor="">
					<span class="Title1"><strong><%=lp.getDob()%></strong> </span>
				</td>

			</tr>
			<tr bgcolor="#asHblue">
				<td bgcolor=>
					<span class="Title1"><strong>RegistredDate</strong> </span>
				</td>
				<td bgcolor=>
					<span class="Title1"><strong><%=lp.getLdate()%></strong> </span>
				</td>

			</tr>

		</table>
		<p></p>


		<table border="1" align="center" bordercolor="#asHblue"
			bgcolor="#asHblue" width="403" height="116">
			<br />
			<br />
			<tr>
				<strong><span class="Title"><u> Address Details<br />
							<br /> </u> </span> </strong>
			</tr>
			<tr>

				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						HouseNo
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=ad.getHouseno()%></span>
				</td>
			</tr>
			<tr>
				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						Street
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=ad.getStreet()%></span>
				</td>
			</tr>

			<tr>
				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						City
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=ad.getCity()%></span>
				</td>
			</tr>
			<tr>
				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						State
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=ad.getState()%></span>
				</td>
			</tr>
			<tr>
				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						Country
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=ad.getCountry()%></span>
				</td>
			</tr>
			<tr>
				<td bgcolor="#CCCCCC">
					<div align="center" class="Title">
						PhoneNo
					</div>
				</td>
				<td bgcolor="#FFFFFF">
					<span class="Title"><%=lp.getPhno()%></span>
				</td>
			</tr>











		</table><jsp:include page="header1.jsp" />
	</body>
</html>