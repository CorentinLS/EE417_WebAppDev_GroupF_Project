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
<title>GFB: Home Address</title>
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
		<h2>Home Address</h2>
		<p>Your GFB card will be shipped to this address. We can only<br/>
	       send cards to residential addresses.</p>
	 
		<!-- use my location -->
		<form name="form" id="form" class="form"  method="POST" action="RegistrationServlet">
			<p>House Number <input type="text" name = "houseNum" required> Street Name <input type="text" name = "streetName" required></p>
		
			<p>		
				<!-- When mouse focus on date, it will disappear, when it leave, it display again  -->
				<input name="address1" id = "address" type="text" value="Postcode" 
				onfocus="this.value=''" 
				onblur="if(this.value==''){this.value='Postcode'}" required>
				
				<input name="addresse2" id = "address" type="text" value="City" 
				onfocus="this.value=''" 
				onblur="if(this.value==''){this.value='City'}" required>		
			
				<input name="address3" id = "address" type="text" value="Country" 
				onfocus="this.value=''" 
				onblur="if(this.value==''){this.value='Country'}" required>	
			</p>
			<p>
				<input name = "addInfo" id = "additionalInformation" type="text" value="Additional Information" 
				onfocus="this.value=''" 
				onblur="if(this.value==''){this.value='Additional Information'}" required>		
			</p>
			<input id = "btnContinue" type="submit" value="Submit">
		</form>
	</div>
	
	<input id = "btnBack" type = "button" value = "Back" onclick ="window.location='mobilePhoneNumber.jsp'">
	<input id = "btnContinue" type = "button" value = "Continue" onclick ="window.location='additionalInformation.jsp'">
	
</body>
</html>