<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>
<%@ page import="com.tap.model.OrderItem"%>

<%
Order order = (Order) request.getAttribute("order");

List<OrderItem> orderItems =
(List<OrderItem>) request.getAttribute("orderItems");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Order Details | QuickBite</title>

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

background:#823513;

padding:18px 40px;

display:flex;

justify-content:space-between;

align-items:center;

color:white;

}

.logo{

font-size:30px;

font-weight:bold;

color:#faae33;

}

.navbar a{

color:white;

text-decoration:none;

font-size:18px;

font-weight:bold;

}

.navbar a:hover{

color:#faae33;

}

/* ================= HEADING ================= */

.heading{

text-align:center;

margin:35px;

font-size:42px;

color:#823513;

font-weight:bold;

}

/* ================= ORDER INFO ================= */

.order-info{

width:90%;

margin:auto;

background:white;

padding:25px;

border-radius:18px;

box-shadow:0 5px 15px rgba(0,0,0,.1);

margin-bottom:35px;

}

.order-info h2{

color:#823513;

margin-bottom:15px;

}

.order-info p{

margin:10px 0;

font-size:18px;

}

/* ================= ITEMS ================= */

.container{

width:90%;

margin:auto;

display:flex;

flex-direction:column;

gap:25px;

margin-bottom:40px;

}

.card{

display:flex;

background:white;

border-radius:18px;

overflow:hidden;

box-shadow:0 5px 15px rgba(0,0,0,.12);

}

.image{

width:260px;

height:180px;

overflow:hidden;

}

.image img{

width:100%;

height:100%;

object-fit:cover;

}

.details{

flex:1;

padding:20px;

display:flex;

flex-direction:column;

justify-content:center;

}

.name{

font-size:28px;

font-weight:bold;

color:#823513;

margin-bottom:10px;

}

.price{

font-size:20px;

color:green;

font-weight:bold;

margin-bottom:10px;

}

.qty{

font-size:18px;

margin-bottom:10px;

}

.total{

font-size:22px;

font-weight:bold;

color:#1c8d2c;

}

/* ================= GRAND TOTAL ================= */

.summary{

width:90%;

margin:auto;

background:white;

padding:25px;

border-radius:18px;

box-shadow:0 5px 15px rgba(0,0,0,.1);

text-align:right;

}

.summary h2{

color:#823513;

margin-bottom:15px;

}

.summary h1{

color:green;

}

/* ================= BUTTON ================= */

.buttons{

width:90%;

margin:40px auto;

display:flex;

gap:20px;

}

.btn{

flex:1;

text-align:center;

padding:16px;

border-radius:10px;

text-decoration:none;

font-weight:bold;

font-size:18px;

transition:.3s;

}

.back{

background:#823513;

color:white;

}

.back:hover{

background:#9f531b;

}

.home{

background:#faae33;

color:#823513;

}

.home:hover{

background:#ffbf47;

}

/* ================= RESPONSIVE ================= */

@media(max-width:900px){

.card{

flex-direction:column;

}

.image{

width:100%;

height:250px;

}

.heading{

font-size:32px;

}

}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">

QuickBite

</div>

<a href="myOrders">

← My Orders

</a>

</div>

<h1 class="heading">

Order Details

</h1>

<div class="order-info">

<h2>

Order #<%=order.getOrderID()%>

</h2>

<p>

<b>Order Date :</b>

<%=order.getOrderDate()%>

</p>

<p>

<b>Status :</b>

<%=order.getStatus()%>

</p>

<p>

<b>Payment Method :</b>

<%=order.getPaymentMethod()%>

</p>

</div>

<div class="container">

<%

for(OrderItem item : orderItems){

%>

<div class="card">

<div class="image">

<img src="<%=item.getMenu().getImagePath()%>">

</div>

<div class="details">

<div class="name">

<%=item.getMenu().getItemName()%>

</div>

<div class="price">

₹ <%=item.getMenu().getPrice()%>

</div>

<div class="qty">

Quantity :

<b>

<%=item.getQuantity()%>

</b>

</div>

<div class="total">

Item Total :

₹ <%=item.getItemTotal()%>

</div>

</div>

</div>

<%

}

%>

</div>

<div class="summary">

<h2>

Grand Total

</h2>

<h1>

₹ <%=order.getTotalAmount()%>

</h1>

</div>

<div class="buttons">

<a href="myOrders"

class="btn back">

← Back To Orders

</a>

<a href="restaurants"

class="btn home">

🏠 Continue Shopping

</a>

</div>

</body>

</html>