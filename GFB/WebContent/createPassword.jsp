<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        .content{
			margin-left:43%;
			margin-top:-500px;
        }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href ="registerPage_style.css"/>
<!-- create password eye link -->
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
<title>GFB: Create Password</title>
</head>
<body>
	<ul>
		<li>
        	<a href="index.jsp"><img class="logo" src = "images/logo.jpg"/></a>
        </li>
    </ul>
    <div class = "navBar">
        <ul>
		<li>
        	<a href="registerPage.jsp">Personal Information</a>
        </li>
        <li>
        	<a href="mobilePhoneNumber.jsp">Mobile Phone Number</a>
        </li>
        <li>
        	<a href="homeAddress.jsp">Home Address</a>
        </li>
        <li>
        	<a href="additionalInformation.jsp">Additional Information</a>
        </li>
        <li>
        	<a href="createPassword.jsp">Create Password</a>
        </li>
        <li>
        	<a href="createAccount.jsp">Create Account</a>
        </li>
        </ul>
        </div>
	
	<div class = "content">
		<h2>Create Password</h2>
		<p>Please enter your password</p>
		
		<form name="form" id="form" class="form"  method="POST" action="RegistrationServlet">
 			<input type="password" id="pwd" name="password" placeholder="Create your password"/>
            	<i class="fa fa-eye" onclick="showhide()" id="eye"></i>
            <input id = "btnContinue" type="submit" value="Submit">
        </form>

		<!-- javascript about enter a password -->
        <script type="text/javascript">
            var eye = document.getElementById("eye");
            var pwd = document.getElementById("pwd");

            function showhide(){
                    if (pwd.type == "password") {
                        pwd.type = "text";
                            eye.className='fa fa-eye-slash'
                    }else {
                        pwd.type = "password";
                        eye.className='fa fa-eye'
                    }
            }
    	</script> 
	</div>
	
	<input id = "btnBack" type = "button" value = "Back" onclick ="window.location='additionalInformationStatus.jsp'">
	<input id = "btnContinue" type = "button" value = "Continue" onclick ="window.location='createAccount.jsp'">
	
</body>
</html>