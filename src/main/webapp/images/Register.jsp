<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<style>

/* All CSS Here */

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background-color:#fdfaf6;
}

.signup-container{
    border-top:4px solid #faae33;
    background:white;
    padding:30px;
    max-width:450px;
    margin:50px auto;
    border-radius:8px;
    box-shadow:0 4px 15px rgba(0,0,0,0.08);
}

h1{
    color:#823513;
}

input,
select{
    width:100%;
    padding:12px;
    margin:10px 0;
    border:1px solid #9f531b;
    border-radius:4px;
}

input:focus,
select:focus{
    outline:none;
    border-color:#faae33;
    box-shadow:0 0 5px rgba(250,174,51,0.4);
}

button{
    width:100%;
    padding:12px;
    background:#823513;
    color:white;
    border:none;
    border-radius:4px;
    font-weight:bold;
    cursor:pointer;
}

button:hover{
    background:#9f531b;
}

.terms{
    margin-top:15px;
    text-align:center;
    font-size:13px;
}

.terms a{
    color:#faae33;
    text-decoration:none;
}

</style>

</head>

<body>

<div class="signup-container">

    <h1>Sign Up</h1>

    <form action="register" method="post">

        <input type="text"
               name="username"
               placeholder="Username"
               required>

        <input type="email"
               name="email"
               placeholder="Email"
               required>

        <input type="password"
               name="password"
               placeholder="Password"
               required>

        <input type="text"
               name="address"
               placeholder="Address"
               required>

       <select name="role" required>

		    <option value="">
		        Select Role
		    </option>
		
		    <option value="customer">
		        customer
		    </option>
		
		    <option value="admin">
		        admin
		    </option>

</select>
        <button type="submit">
            CONTINUE
        </button>

        <p class="terms">

            By creating an account, I accept the

            <a href="#">
                Terms &amp; Conditions
            </a>

            and

            <a href="#">
                Privacy Policy &amp; Security
            </a>

        </p>

    </form>

</div>

</body>
</html>