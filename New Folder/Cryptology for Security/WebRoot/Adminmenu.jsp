<style type="text/css">
.tab{
font-family: arial, verdana, san-serif;
font-size: 14px;
}
.asd
{
text-decoration: none;
font-family: arial, verdana, san-serif;
font-size: 13px;
color:#4234ff;
}

/*****remove the list style****/
#nav {
margin:0;
padding:0;
list-style:none;
}

/*****LI display inline *****/
#nav li {
float:left;
display:block;
width:100px;
background:LightBlue;
position:relative;
z-index:500;
margin:0 1px;
}

/*****parent menu*****/
#nav li a {
display:block;
padding:8px 5px 0 5px;
font-weight:700;
height:23px;
text-decoration:none;
color:#ffffff;
text-align:center;
color:Blak;
}

#nav li a:hover
{
color:;
}

/* style for default selected value */ #nav a.selected {
color:#4234ff;
}
/* submenu */ #nav ul
{
position:absolute;
left:0;
display:none;
margin:0 0 0 -1px;
padding:0;
list-style:none;
}

#nav ul li
{
width:100px;
float:left;
border-top:1px solid #fff;
}

/* display block will make the link fill the whole area of LI */ #nav ul a
{
display:block;
height:15px;
padding: 8px 5px;
color:;
}

#nav ul a:hover
{
text-decoration:underline;
padding-left:15px;
}
</style>

<script type="text/javascript" src="scripts/jquery.js">
</script>

<script type="text/javascript">
$(document).ready(function () {
$('#nav li').hover(
function () {
//show its submenu
$('ul', this).slideDown(350);
},
function () {
//hide its submenu
$('ul', this).slideUp(350);
}
);
});
</script>
<input type=hidden name=arav value="4*#*#*1*#*#*1*#*#*1*#*#*1"><ul id='nav'>
<li> <a href="<%=request.getContextPath()+"/InboxAction"%>">INBOX</a>
<ul>
</ul>
<li> <a href="<%=request.getContextPath()+"/CreateNewMail.jsp"%>">COMPOSEMAIL</a>
<ul>
</ul>
<li> <a href="<%=request.getContextPath()+"/ShowMailsAction"%>">SENTMAIL</a>
<ul>
</ul>
<li> <a href="<%=request.getContextPath()+"/ViewProfileAction"%>">VIEWPROFILE</a>
<ul>
</ul>
<li> <a href="<%=request.getContextPath()+"/ShowUserAction"%>">USERPROFILE</a>
<ul>
</ul>
<li> <a href="./changepassword.jsp?userid=<%=session.getAttribute("user")%>">CHANGEPASSWORD</a>
<ul>
</ul>
<li> <a href="<%=request.getContextPath()+"/LogoutAction"%>">LOGOUT</a>
<ul>
</ul>
</li>
</ul>



