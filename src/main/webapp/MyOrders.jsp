<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI';
}

body{
background:#fffaf3;
}

.header{

background:#823513;

padding:20px;

color:white;

text-align:center;

font-size:32px;

font-weight:bold;
}

.container{

width:90%;

margin:40px auto;
}

.card{

background:white;

padding:25px;

margin-bottom:25px;

border-radius:15px;

box-shadow:0 5px 15px rgba(0,0,0,.1);

display:flex;

justify-content:space-between;

align-items:center;
}

.left h2{

color:#823513;

margin-bottom:10px;
}

.left p{

margin:6px 0;

color:#666;
}

.status{

padding:8px 18px;

border-radius:20px;

background:#faae33;

color:#823513;

font-weight:bold;
}

.price{

font-size:24px;

color:green;

font-weight:bold;
}

.btn{

margin-top:15px;

display:inline-block;

padding:10px 18px;

background:#823513;

color:white;

text-decoration:none;

border-radius:10px;
}

.btn:hover{

background:#9f531b;
}

.empty{

text-align:center;

margin-top:120px;
}

</style>

</head>

<body>

<div class="header">

My Orders

</div>

<div class="container">

<%

List<Order> orders =
(List<Order>)request.getAttribute("orders");

if(orders!=null && !orders.isEmpty()){

for(Order order:orders){

%>

<div class="card">

<div class="left">

<h2>

Order #<%=order.getOrderID()%>

</h2>

<p>

Order Date :
<%=order.getOrderDate()%>

</p>

<p>

Payment :
<%=order.getPaymentMethod()%>

</p>

<p>

<span class="status">

<%=order.getStatus()%>

</span>

</p>

<a

class="btn"

href="orderDetails?orderId=<%=order.getOrderID()%>">

View Details

</a>

</div>

<div class="right">

<div class="price">

₹ <%=order.getTotalAmount()%>

</div>

</div>

</div>

<%

}

}else{

%>

<div class="empty">

<h2>

No Orders Yet

</h2>

</div>

<%

}

%>

</div>

</body>

</html>