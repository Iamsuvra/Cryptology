

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
	<script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>" type="text/javascript"></script>
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
	</head>
	
	<body onload="javascript:disableBackButton()" >
		<jsp:include page="header.jsp"></jsp:include></br></br>
<jsp:include page="footer1.jsp"></jsp:include>
		<center>
		<%if(request.getAttribute("status")!=null) {%>
		<%=request.getAttribute("status") %><%} %>
			<form action="./login" method=post name="login">
				<table border="0" align="center" bgcolor="#FFFFCC" width="80%">
					<tr>
						<td height="120" align="right"></td>
						<td>
							<table border="1" align="center" bgcolor='#FFFFCC'>
								<tr align="center">
									<strong>
										<center>
											<h3>
												    Login Form
											</h3>
										</center> </strong>

								</tr>
								<tr>
									<td align='right'>
										<span class="Title">UserID :</span>
									</td>
									<td>
										<input type="text" name="t1">
									</td>
								</tr>
								<tr>
									<td align='right'>
										<span class="Title">Password :</span>
									</td>
									<td>
										<input type="password" name="t2">
									</td>
								</tr>


								<tr>
									<td colspan="2">
										<div align="center" class="style11">
											<input type="submit" name="Submit" value="Sign In">
											&nbsp;
											<input name="Input2" type="reset" value="Clear">
										</div>
									</td>
								</tr>
							</table>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<div align="center">
								<a href="Recoverpassword.jsp"><strong><font
										color="#000000">Forgot Password ! !......</font> </strong> </a>
							</div>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<div align="center">
								<a href="Registration.jsp"><strong><font
										color="#000000">New User....?</font> </strong> </a>
							</div>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>

			</form>
			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  	frmvalidator.addValidation("t1","req","Login Name is required");
    frmvalidator.addValidation("t1","alpha","Login Name is Only Characters");
    frmvalidator.addValidation("t2","req","Password is required");
   
  </script>
			<jsp:include page="header1.jsp"></jsp:include>
	</body>
</html>