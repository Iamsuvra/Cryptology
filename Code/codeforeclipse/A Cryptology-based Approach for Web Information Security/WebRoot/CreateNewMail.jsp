<%@page import="com.wc.action.LoginAction;"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
	</head>
	<body>
		<table>
			<tr>
				<td colspan="2" align="center">

				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="header.jsp" />

				</td>
			</tr>
			<tr>
				<td>

					<jsp:include page="header1.jsp" />
				</td>
			</tr>

			<center>
				<form action="./CreateNewMail" method="post" name="create">
					<table width="600" align="center" border="1" cellpadding="3"
						cellspacing="1">
						<tr>
							<td><jsp:include page="footer1.jsp"></jsp:include></td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="black" size="4">From &nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
										type="text" name="from" size="50"
										value="<c:out value="${sessionScope.user}"/>"
										readonly="readonly"> </font>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="black" size="4">To
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
										type="text" size="50" name="to"> </font>
							</td>
						</tr>
						<tr>
							<td align="left">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="black" size="4">Message &nbsp; &nbsp;&nbsp;
									&nbsp; <textarea rows="5" cols="37" name="msg"></textarea> </font>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="black" size="4">Attachments &nbsp; <input
										type="file" size="31" name="attach"> </font>
							</td>
						</tr>
						<tr>
							<td align="center">
								<input type="submit" value="send">
					</table>
				</form>
				<script language="JavaScript" type="text/javascript">
     var frmvalidator  = new Validator("create");
  	frmvalidator.addValidation("to","req","Login Name is required");
    frmvalidator.addValidation("to","alpha","Login Name is Only Characters");
    frmvalidator.addValidation("msg","req","Login Name is required");
    frmvalidator.addValidation("attach","req","Attachment is required");
   
   </script>
			</center>

			<tr>
				<td>
					<jsp:include page="header1.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</body>
</html>
