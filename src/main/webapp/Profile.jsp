<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User"%>

<%
User user=(User)session.getAttribute("loggedInUser");

if(user==null){

response.sendRedirect("Login.jsp");
return;

}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Profile | QuickBite</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{

background:#fffaf3;

}

/* NAVBAR */

.navbar{

height:80px;

background:#823513;

display:flex;

justify-content:space-between;

align-items:center;

padding:0 60px;

}

.logo{

font-size:34px;

font-weight:bold;

color:#faae33;

}

.nav-links{

display:flex;

gap:30px;

}

.nav-links a{

text-decoration:none;

color:white;

font-size:18px;

font-weight:bold;

transition:.3s;

}

.nav-links a:hover{

color:#faae33;

}

/* PROFILE CARD */

.container{

width:700px;

margin:60px auto;

background:white;

padding:40px;

border-radius:20px;

box-shadow:0 10px 30px rgba(0,0,0,.12);

}

.avatar{

width:120px;

height:120px;

margin:auto;

border-radius:50%;

background:#faae33;

display:flex;

justify-content:center;

align-items:center;

font-size:55px;

color:white;

margin-bottom:25px;

}

.title{

text-align:center;

font-size:38px;

font-weight:bold;

color:#823513;

margin-bottom:35px;

}

.row{

display:flex;

justify-content:space-between;

padding:18px 0;

border-bottom:1px solid #eee;

font-size:20px;

}

.label{

font-weight:bold;

color:#823513;

}

.value{

color:#444;

}

.buttons{

margin-top:40px;

display:flex;

gap:20px;

}

.btn{

flex:1;

padding:15px;

text-align:center;

text-decoration:none;

border-radius:10px;

font-size:18px;

font-weight:bold;

transition:.3s;

}

.orders{

background:#faae33;

color:#823513;

}

.orders:hover{

background:#ffbe45;

}

.logout{

background:#823513;

color:white;

}

.logout:hover{

background:#9f531b;

}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">

QuickBite

</div>

<div class="nav-links">

<a href="restaurants">

Home

</a>

<a href="myOrders">

My Orders

</a>

<a href="Cart.jsp">

Cart

</a>

</div>

</div>

<div class="container">

<div class="avatar">

👤

</div>

<div class="title">

My Profile

</div>

<div class="row">

<div class="label">

Username

</div>

<div class="value">

<%=user.getUserName()%>

</div>

</div>

<div class="row">

<div class="label">

Email

</div>

<div class="value">

<%=user.getEmail()%>

</div>

</div>

<div class="row">

<div class="label">

Address

</div>

<div class="value">

<%=user.getAddress()%>

</div>

</div>

<div class="row">

<div class="label">

Role

</div>

<div class="value">

<%=user.getRole()%>

</div>

</div>

<div class="row">

<div class="label">

Created On

</div>

<div class="value">

<%=user.getCreatedDate()%>

</div>

</div>

<div class="row">

<div class="label">

Last Login

</div>

<div class="value">

<%=user.getLastLoginDate()%>

</div>

</div>

<div class="buttons">

<a href="myOrders"
class="btn orders">

My Orders

</a>

<a href="logout"
class="btn logout">

Logout

</a>

</div>

</div>

</body>

</html>