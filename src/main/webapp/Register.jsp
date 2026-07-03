<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>QuickBite | Register</title>

<link rel="stylesheet" href="style.css">

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{

background:#fffaf3;

display:flex;

justify-content:center;

align-items:center;

min-height:100vh;

}

.register-container{

width:460px;

background:#fff;

padding:35px;

border-radius:15px;

box-shadow:0 10px 25px rgba(0,0,0,.12);

border-top:6px solid #faae33;

}

.logo{

text-align:center;

font-size:38px;

font-weight:bold;

color:#823513;

margin-bottom:20px;

}

.logo span{

color:#faae33;

}

h2{

text-align:center;

color:#823513;

margin-bottom:10px;

}

.subtitle{

text-align:center;

color:#666;

margin-bottom:25px;

}

.subtitle a{

text-decoration:none;

font-weight:bold;

color:#faae33;

}

.subtitle a:hover{

color:#823513;

}

.line{

height:2px;

background:#faae33;

margin-bottom:25px;

}

.form-group{

margin-bottom:18px;

}

label{

display:block;

margin-bottom:8px;

font-weight:bold;

color:#823513;

}

input{

width:100%;

padding:13px;

border:1px solid #ccc;

border-radius:8px;

font-size:16px;

transition:.3s;

}

input:focus{

outline:none;

border-color:#faae33;

box-shadow:0 0 8px rgba(250,174,51,.35);

}

select{

width:100%;

padding:13px;

border:1px solid #ccc;

border-radius:8px;

font-size:16px;

}

button{

width:100%;

padding:15px;

margin-top:10px;

background:#823513;

color:white;

border:none;

border-radius:10px;

font-size:18px;

font-weight:bold;

cursor:pointer;

transition:.3s;

}

button:hover{

background:#9f531b;

}

</style>

</head>

<body>

<div class="register-container">

<div class="logo">

Quick<span>Bite</span>

</div>

<h2>

Create Account

</h2>

<p class="subtitle">

Already have an account?

<a href="Login.jsp">

Login

</a>

</p>

<div class="line"></div>

<form action="register" method="post">

<div class="form-group">

<label>Username</label>

<input
type="text"
name="username"
placeholder="Enter Username"
required>

</div>

<div class="form-group">

<label>Email</label>

<input
type="email"
name="email"
placeholder="Enter Email"
required>

</div>

<div class="form-group">

<label>Password</label>

<input
type="password"
name="password"
placeholder="Enter Password"
required>

</div>

<div class="form-group">

<label>Address</label>

<input
type="text"
name="address"
placeholder="Enter Address"
required>

</div>

<div class="form-group">

<label>Role</label>

<select name="role">

<option value="customer">

Customer

</option>

<option value="admin">

Admin

</option>

</select>

</div>

<button type="submit">

Create Account

</button>

</form>

</div>

</body>

</html>