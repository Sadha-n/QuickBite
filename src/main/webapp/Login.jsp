<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="style.css">

<style>
    body {
        background-color: #fdfaf6; /* Light warm background to complement the theme */
        font-family: Arial, sans-serif;
    }
    
    .login-container {
        border-top: 4px solid #faae33; /* Accent top border */
        background: #ffffff;
        padding: 30px;
        max-width: 450px;
        margin: 50px auto;
        box-shadow: 0 4px 15px rgba(0,0,0,0.05);
        border-radius: 8px;
    }

    h1 {
        color: #823513; /* Deep warm brown for main heading */
        margin-bottom: 5px;
    }

    p {
        color: #9f531b; /* Muted terracotta/orange-brown for secondary text */
    }

    .login-link {
        color: #faae33; /* Vibrant warm orange-yellow for the actionable link */
        text-decoration: none;
        font-weight: bold;
    }

    .login-link:hover {
        color: #9f531b;
    }

    .line {
        height: 2px;
        background-color: #faae33; /* Line matching the accent color */
        margin: 15px 0;
    }

    input[type="email"], 
    input[type="password"] {
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        border: 1px solid #9f531b; /* Themed border */
        border-radius: 4px;
        box-sizing: border-box;
    }

    input:focus {
        outline: none;
        border-color: #faae33; /* Focus glow changes to accent orange */
        box-shadow: 0 0 5px rgba(250, 174, 51, 0.4);
    }

    button[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #823513; /* Strong primary background color for the button */
        color: white;
        border: none;
        border-radius: 4px;
        font-weight: bold;
        cursor: pointer;
        transition: background 0.3s ease;
    }

    button[type="submit"]:hover {
        background-color: #9f531b; /* Shifts to the secondary tone on hover */
    }
</style>
</head>
<body>

<div class="login-container">

    <div class="top-section">

        <div>
            <h1>Login</h1>

            <p>
                or
                <a href="Register.jsp" class="login-link">
                    create an account
                </a>
            </p>

            <div class="line"></div>
        </div>

        <div class="food-image">
            <img src="images/food.jpg" alt="Food">
        </div>

    </div>
    
	    
	    <%
	String errorMessage =
	    (String)request.getAttribute(
	            "errorMessage");
	
	if(errorMessage != null){
	%>
	
	<div style="
	color:red;
	margin-bottom:15px;
	font-weight:bold;
	text-align:center;">
	    <%= errorMessage %>
	</div>
	
	<%
	}
	%>

    <form action="login" method="post">

    <input type="text"
           name="username"
           placeholder="Username"
           required>

    <input type="password"
           name="password"
           placeholder="Password"
           required>

    <button type="submit">
        LOGIN
    </button>

</form>

</div>

</body>
</html>