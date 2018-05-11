<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
<script>

//var x_win = window.self; 

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var userName=document.register.userName.value;
window.location.href="./ChekUserAction?userName="+userName;

} 
</script>

		
		
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
		<body>
		<jsp:include page="header.jsp"></jsp:include>
		   <h3><div align="center"><span class=subHead><br>Register Form </span></div></h3>
<form action="./RegistrationAction" method="post" name="register" onSubmit="return validate()">
 <!--<table border="1"><tr><td></td></tr></table>-->
 <input type="hidden" name="port" value="<%=request.getLocalPort() %>">
 <input type="hidden" name="host" value="<%=request.getServerName() %>">
 <br>
 <%if(request.getParameter("status")!=null){ %>
      <%=request.getParameter("status") %><%} %>
 <table align="left" width=70%>
<th colspan="6" bgcolor="#asHblue"><span class=Title>Account Details</span></th>
<tr></tr><tr></tr>
 <tr>
    <td><pre><span class=Title>    User Name</span></pre></td>
    <td width="303"><input type="text" name="userName" value="<%if(request.getParameter("userName")!=null)out.print(request.getParameter("userName")); %>" size="20" onBlur="goOn()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=Title><%if(request.getParameter("status1")!=null)                                       out.print(request.getParameter("status1"));    %></span></td>
</tr>
<tr>
 <td><pre><span class=Title>    PassWord</span></pre></td>
  <td>
    
        <input type="password" name="password"  onkeyup="testPassword(document.forms.register.password.value);" onChange="Encrypt(document.forms.register.password.value);"></td></tr>
        <tr><td></td><td>
     <span class=Title><a id="Words"> Strength:</a></td>
      <td><table cellpadding=0 cellspacing=0><tr><td height=15  bgcolor=#dddddd></td></tr></table></td>
</tr>
<tr>
    <td><pre><span class=Title>    Confirm</span><pre></td>
    <td><input type="password" name="conformpassword" value="" size="20" onBlur="checkconformpassword()"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    SecurityQuestion</span></pre></td>
    <td><select name="squest">
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
     
      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option>
    </select></td>
</tr>
 
<tr>
    <td><pre><span class=Title>    Security Answer</span></pre></td>
    <td><input type="text" name="secrete" value="" size="20"/></td>
</tr>

<tr></tr><tr></tr>
  <th colspan="6" bgcolor="#asHblue"><span class=Title>Personal Details</span>  </th>
  <tr></tr><tr></tr>
  <tr>
    <td><pre><span class=Title>    First Name</span></pre></td>
    <td width="276"><input type="text" name="firstName" value=""></td>
  </tr>
<tr>
    <td width="139"><pre><span class=Title>    Last Name</span></pre></td>
    <td width="276">
      <input type="text" name="lastName" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title> Birth Date</span></pre></td>
    <td>
   <input type="text" name="dob" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> <img  src="images/cal.gif" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
    <tr>
    <td><pre><span class=Title>    Browse Photo</span></pre></td>
    <td><input type="file" name="photo" class="textfield" onChange="preview(this)" /></td>
  </tr>
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="#asHblue"><center><span class=Title>Contact Details</span>
</center></th>
<tr></tr><tr></tr>

<tr>
    <td><pre><span class=Title>    House No</span></pre></td>
    <td><input type="text" name="houseNo" value="" size="20"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    Street</span></pre></td>
    <td><input type="text" name="street" value="" size="20"/></td>
</tr>

<tr>
    <td><pre><span class=Title>    Phone No</span></pre></td>
    <td><input type="text" name="phoneNo" value="" size="20" onBlur="ValidateForm()"/></td>
</tr>
<th colspan="5">&nbsp;</th>
<tr></tr><tr></tr>

<tr><td></td>
    <td align="center"><font size="3" face="Verdana">
    <pre>                   <input type="submit" name="register" value="Register"/>&nbsp;  <input type="reset" name="cancel" value="Cancel"/>
   </pre> </font></td>
    <td align="center"></td>
</tr>
</table>
 <p><br/>
     <br/>
   <br/>
   </p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p><br/>
      </p>
 <table border="0" align="center">

<tr>
 <img alt="See Photo Here" id="previewField" src="images/flag.gif" height="150" width="120">
 </tr></table><table  border="0" align="center">
    <tr>
    <td><pre><span class=Title>    Gender</span></pre></td>
    <td><select name="gender">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="Male"><font size="3" face="Verdana">Male</font></option>
    <option value="Female"><font size="3" face="Verdana">Female</font></option>
    </select>
    </td>
   
 
  <tr rowspan="2"></tr>
  <tr>
    <td width="120"><pre><span class=Title>   City</span></pre></td>
    <td width="273">
      <input type="text" name="city" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   State</span></pre></td>
    <td>
      <input type="text" name="state" value="" size="20"/>
    </td>
  </tr>
  <tr>
    <td><pre><span class=Title>   Country</span></pre></td>
    <td>
      <input type="text" name="country" value="" size="20"/>
   </td>
  </tr>
  
  <tr>
    <td><pre><span class=Title>   Pin</span></pre></td>
    <td>
      <input type="text" name="pin" value="" size="20" onChange="showStatus()"/>
    </td>
  </tr>
  
<input type="hidden" name="homeaddresstype" value=""/>
<input type="hidden" name="homehouseno"/>
<input type="hidden" name="homestreet"/>
<input type="hidden" name="homephonetype" value=""/>
<input type="hidden" name="homecountry"/>
<input type="hidden" name="homepin"/>
<input type="hidden" name="homestate" value=""/>
<input type="hidden" name="homephoneno"/>
<input type="hidden" name="homecity"/>



 <input type="hidden" name="officeaddresstype" value=""/>
<input type="hidden" name="officehouseno"/>
<input type="hidden" name="officestreet"/>
<input type="hidden" name="officephonetype" value=""/>
<input type="hidden" name="officecountry"/>
<input type="hidden" name="officepin"/>
<input type="hidden" name="officestate" value=""/>
<input type="hidden" name="officephoneno"/>
<input type="hidden" name="officecity"/>



<input type="hidden" name="personaladdresstype" value=""/>
<input type="hidden" name="personalhouseno"/>
<input type="hidden" name="personalstreet"/>
<input type="hidden" name="personalphonetype" value=""/>
<input type="hidden" name="personalcountry"/>
<input type="hidden" name="personalpin"/>
<input type="hidden" name="personalstate" value=""/>
<input type="hidden" name="personalphoneno"/>
<input type="hidden" name="personalcity"/>
</table>
</form>

<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
   frmvalidator.addValidation("gender","dontselect=0");
   frmvalidator.addValidation("dob","req","Please enter your DOB"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
  
   frmvalidator.addValidation("addressType","dontselect=0");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     frmvalidator.addValidation("phoneType","dontselect=0");
   frmvalidator.addValidation("phoneNo","req");
  
  frmvalidator.addValidation("phoneNo","maxlen=50");
  frmvalidator.addValidation("phoneNo","numeric");
 frmvalidator.addValidation("phoneNo","Phone");
   
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   
   frmvalidator.addValidation("userName","req","Please enter your Username");
   frmvalidator.addValidation("password","req","Please enter your Password");
   frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("secrete","req","Please enter your Answer");
    frmvalidator.addValidation("squest","dontselect=0");
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
  
   
    
 </script>
 											
    <jsp:include page="footer.jsp"></jsp:include>


	</body>
</html>
