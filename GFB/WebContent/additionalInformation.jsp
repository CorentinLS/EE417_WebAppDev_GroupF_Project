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
<title>GFB: Additional Information</title>
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
	
	<div class="content">
		<h2>Additional Information</h2>
		<p>Please tell us your nationality and place of birth.</p>
		<form name="form" id="form" class="form"  method="POST" action="RegistrationServlet">
			<p>Nationality (Country) <input type="text" name="nationality" required></p> <!-- as shown on passport -->
			<p>City of Birth <input type="text" name="cityBirth" required></p>
			<p>Country of Birth <input type="text" name="countryBirth" required></p>
			<p>What is your legal gender? You can only select one of these two options.</p>
			<!-- Only can select one of these two options -->
			<p>
				<input type="radio" name="type1">Female</p>
			<p>
				<input type="radio" name="type1">Male</p>
			<input id = "btnContinue" type="submit" value="Submit">
		</form>
	</div>
	
	<input id = "btnBack" type = "button" value = "Back" onclick ="window.location='homeAddress.jsp'">
	<input id = "btnContinue" type = "button" value = "Continue" onclick ="window.location='additionalInformationStatus.jsp'">
	
</body>
</html>