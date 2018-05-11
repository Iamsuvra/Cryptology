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
<jsp:include page="header.jsp"></jsp:include>
		<table>
			
			<tr>
				<td colspan="2" align="center">
					<jsp:include page="footer1.jsp"></jsp:include>
				</td>
			</tr>
			
			


			<center>
				
				<FORM action="./recoverpass" method="post" name="register">
					<TABLE border="0" align="center" bordercolor="#asHblue"  width=80%>

						<TR>
							<TD>
								<TABLE border="0" align="center" bordercolor="#asHblue" width=80%>
<tr><h3>
					<strong>Forgot Password Form </strong>
				</h3></tr>


									<TR>
										<TD align="right"></TD>
										<TD>
											<TABLE border="0" align="center" bgcolor="#asHblue">
												<TR>
													<TD>
														<span class=Title> Login Name</span>
													</TD>
													<TD>
														<INPUT type="text" name="username">
													</TD>
												</TR>
												<TR>
													<TD>
														<span class=Title> Secret Question</span>
													</TD>
													<TD>
														<span class=Title> <select name="squest">
																  <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
															</select> </span>
													</TD>
												</TR>

												<TR>
													<TD>
														<span class=Title> Secret Answer</span>
													</TD>
													<TD>
														<INPUT type="text" name="sanswer">
													</TD>
												</TR>
												<TR>
													<TD colspan="2">
														<span class=Title>
															<DIV align="center">
																<INPUT type="submit" value="Recover">
																&nbsp;
																<INPUT type="reset" value="Clear">
															</DIV> </span>
													</TD>
												</TR>
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

					<jsp:include page="header1.jsp" />
				</td>
			</tr>
		</table>

	</body>

</html>
