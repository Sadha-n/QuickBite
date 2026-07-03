<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<%@ page import="java.util.Collection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout | QuickBite</title>

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

/* ================= NAVBAR ================= */

.navbar{

height:80px;

background:#823513;

display:flex;

justify-content:space-between;

align-items:center;

padding:0 40px;

color:white;
}

.logo{

font-size:30px;

font-weight:bold;

color:#faae33;
}

.navbar a{

text-decoration:none;

color:white;

font-weight:bold;
}

/* ================= TITLE ================= */

.title{

text-align:center;

margin:35px;

color:#823513;

font-size:40px;
}

/* ================= MAIN ================= */

.main{

width:92%;

margin:auto;

display:grid;

grid-template-columns:1fr 420px;

gap:35px;

align-items:start;
}

/* ================= LEFT ================= */

.left{

background:white;

padding:30px;

border-radius:20px;

box-shadow:0 10px 25px rgba(0,0,0,.1);
}

.left h2{

color:#823513;

margin-bottom:20px;
}

.info{

margin-bottom:18px;
}

.info label{

font-weight:bold;

display:block;

margin-bottom:6px;

color:#555;
}

.info input{

width:100%;

padding:12px;

border:1px solid #ddd;

border-radius:8px;

font-size:16px;
}

/* ================= PAYMENT ================= */

.payment{

margin-top:30px;
}

.payment h3{

color:#823513;

margin-bottom:15px;
}

.payment label{

display:block;

margin:12px 0;

font-size:18px;

cursor:pointer;
}

/* ================= RIGHT ================= */

.right{

background:white;

padding:25px;

border-radius:20px;

box-shadow:0 10px 25px rgba(0,0,0,.1);

position:sticky;

top:20px;
}

.right h2{

color:#823513;

margin-bottom:20px;
}

/* ================= ITEM ================= */

.item{

display:flex;

justify-content:space-between;

margin-bottom:15px;

font-size:16px;
}

.total{

margin-top:20px;

padding-top:20px;

border-top:2px dashed #ddd;

font-size:26px;

font-weight:bold;

color:#1c8d2c;
}

/* ================= BUTTON ================= */

.place-btn{

width:100%;

margin-top:30px;

padding:16px;

border:none;

background:#faae33;

color:#823513;

font-size:20px;

font-weight:bold;

border-radius:12px;

cursor:pointer;

transition:.3s;
}

.place-btn:hover{

background:#823513;

color:white;
}

@media(max-width:900px){

.main{

grid-template-columns:1fr;
}

}

</style>

</head>

<body>

<%

User user=(User)session.getAttribute("loggedInUser");

Cart cart=(Cart)session.getAttribute("cart");

Collection<CartItem> items=cart.getItems();

%>

<nav class="navbar">

<div class="logo">

QuickBite

</div>

<a href="Cart.jsp">

Back To Cart

</a>

</nav>

<h1 class="title">

Checkout

</h1>

<form action="checkout" method="post">

<div class="main">

<!-- LEFT -->

<div class="left">

<h2>

Delivery Details

</h2>

<div class="info">

<label>Name</label>

<input type="text"

value="<%=user.getUserName()%>"

readonly>

</div>

<div class="info">

<label>Email</label>

<input type="email"

value="<%=user.getEmail()%>"

readonly>

</div>

<div class="info">

<label>Delivery Address</label>

<input

type="text"

name="address"

value="<%=user.getAddress()%>"

required>

</div>

<div class="payment">

<h3>

Payment Method

</h3>

<label>

<input

type="radio"

name="paymentMethod"

value="Cash"

checked>

Cash On Delivery

</label>

<label>

<input

type="radio"

name="paymentMethod"

value="UPI">

UPI

</label>

<label>

<input

type="radio"

name="paymentMethod"

value="Card">

Debit / Credit Card

</label>

</div>

</div>

<!-- RIGHT -->

<div class="right">

<h2>

Order Summary

</h2>

<%

for(CartItem item:items){

%>

<div class="item">

<span>

<%=item.getMenu().getItemName()%>

x <%=item.getQuantity()%>

</span>

<span>

₹ <%=item.getItemTotal()%>

</span>

</div>

<%

}

%>

<div class="total">

₹ <%=cart.getTotalPrice()%>

</div>

<button

class="place-btn">

Place Order

</button>

</div>

</div>

</form>

</body>

</html>