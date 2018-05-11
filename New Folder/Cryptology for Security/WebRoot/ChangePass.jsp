<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	</head>
	<body>
<jsp:include page="header.jsp" />
		<table>
			


			<center>
				
				<FORM action="./ChangePassAction" method="post" name="register">
					<TABLE border="0" align="center" bordercolor="#asHblue" width=80%>

						<TR>
							<TD>
								<TABLE border="0" align="center" bgcolor="#asHblue">
<tr>
<h3>
					<strong>Change Password Form </strong>
				</h3>
<tr>

									<TR>
										<TD align="right"></TD>
										<TD>
											<TABLE border="0" align="center">
												<TR>
													<TD>
														<span class=Title> Login Name</span>
													</TD>
													<TD>
														<INPUT type="text" name="t1" value="<c:out value="${sessionScope.user}"/>"readonly="readonly">
													</TD>
												</TR>
												<tr>
					<td><span class=Title>
					  Old Password:
					</span></td>
					<td>
						<input type="password" name="oldpassword" id="newpass"/><div id="pass"></div></td>
				</tr>
				<tr>
					<td><span class=Title>
				  New Password:
					</span></td>
					<td>
						<input type="password" name="newpassword"   id="new" />	<div id="change"></div>				</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center"><strong>
						  <input type="submit" name="Submit" value="Change" />
						</strong></div>				  </td>
				</tr>
											</TABLE>
										</TD>
										<td valign="top">
											<br>
										</td>
										<TD>
											&nbsp;&nbsp;
										</TD>
									</TR>
								</TABLE>
							</TD>
						</TR>
					</TABLE>
				</FORM>
			</center>
			<br />
			<br />
			<tr>
				<td>

					<jsp:include page="footer.jsp" />
				</td>
			</tr>
		</table>

	</body>

</html>
