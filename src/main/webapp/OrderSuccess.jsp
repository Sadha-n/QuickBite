<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
Integer orderId = (Integer)session.getAttribute("orderId");

if(orderId == null){

    response.sendRedirect("restaurants");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Successful</title>

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

height:100vh;
}

.card{

width:550px;

background:white;

padding:50px;

border-radius:20px;

box-shadow:0 15px 40px rgba(0,0,0,.12);

text-align:center;

animation:popup .5s ease;
}

@keyframes popup{

from{

transform:scale(.7);

opacity:0;

}

to{

transform:scale(1);

opacity:1;

}

}

.success{

font-size:90px;

margin-bottom:20px;
}

h1{

color:#1c8d2c;

margin-bottom:15px;

font-size:40px;
}

.order{

font-size:24px;

color:#823513;

margin-bottom:20px;
}

.message{

color:#666;

font-size:18px;

line-height:1.6;

margin-bottom:35px;
}

.info{

background:#fff4dc;

padding:18px;

border-radius:12px;

margin-bottom:35px;
}

.info h3{

color:#823513;

margin-bottom:10px;
}

.info p{

font-size:18px;

color:#555;
}

.buttons{

display:flex;

gap:20px;
}

.btn{

flex:1;

padding:16px;

border-radius:12px;

text-decoration:none;

font-weight:bold;

font-size:18px;

transition:.3s;
}

.continue{

background:#823513;

color:white;
}

.continue:hover{

background:#9f531b;
}

.orders{

background:#faae33;

color:#823513;
}

.orders:hover{

background:#ffbf47;
}

.footer{

margin-top:35px;

color:#999;

font-size:15px;
}

</style>

</head>

<body>

<div class="card">

<div class="success">

✅

</div>

<h1>

Order Placed Successfully

</h1>

<div class="order">

Order ID :
<b>

#<%=orderId%>

</b>

</div>

<p class="message">

Thank you for ordering from
<b>

QuickBite

</b>

Your delicious food is now being prepared.

</p>

<div class="info">

<h3>

Estimated Delivery

</h3>

<p>

🚴 30 - 40 Minutes

</p>

</div>

<div class="buttons">

<a href="restaurants"

class="btn continue">

Continue Shopping

</a>

<a href="myOrders"

class="btn orders">

My Orders

</a>

</div>

<div class="footer">

We appreciate your order ❤️

</div>

</div>

</body>
</html>