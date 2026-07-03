<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<%@ page import="java.util.Collection"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>QuickBite | My Cart</title>

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

/*===================== NAVBAR =====================*/

.navbar{

background:#823513;

height:80px;

display:flex;

justify-content:space-between;

align-items:center;

padding:0 60px;

box-shadow:0 5px 15px rgba(0,0,0,.15);

}

.logo{

font-size:34px;

font-weight:bold;

color:#faae33;

}

.logo span{

color:white;

font-size:18px;

margin-left:5px;

}

.nav-links{

display:flex;

gap:35px;

}

.nav-links a{

text-decoration:none;

color:white;

font-size:18px;

font-weight:600;

transition:.3s;

}

.nav-links a:hover{

color:#faae33;

}

/*===================== HEADING =====================*/

.heading{

text-align:center;

margin-top:35px;

}

.heading h1{

font-size:52px;

color:#823513;

margin-bottom:8px;

}

.line{

width:220px;

height:3px;

background:#faae33;

margin:auto;

position:relative;

border-radius:30px;

}

.line::after{

content:"✦";

position:absolute;

left:50%;

top:-14px;

transform:translateX(-50%);

background:#fffaf3;

padding:0 12px;

color:#faae33;

font-size:22px;

}

/*===================== INFO =====================*/

.info{

width:90%;

margin:25px auto;

background:#fff5eb;

border:1px solid #ffd28a;

padding:15px 22px;

border-radius:10px;

font-size:17px;

color:#823513;

font-weight:600;

}

/*===================== CONTAINER =====================*/

.container{

width:90%;

margin:25px auto;

}

/*===================== CART CARD =====================*/

.card{

display:flex;

background:white;

border-radius:18px;

overflow:hidden;

margin-bottom:25px;

box-shadow:0 10px 25px rgba(0,0,0,.08);

transition:.3s;

}

.card:hover{

transform:translateY(-4px);

box-shadow:0 18px 30px rgba(0,0,0,.12);

}

/*===================== IMAGE =====================*/

.card img{

width:360px;

height:240px;

object-fit:cover;

display:block;

flex-shrink:0;

}

/*===================== DETAILS =====================*/

.details{

flex:1;

padding:28px;

display:flex;

flex-direction:column;

justify-content:center;

}

.name{

font-size:34px;

font-weight:bold;

color:#823513;

margin-bottom:10px;

}

.description{

font-size:19px;

color:#666;

line-height:30px;

margin-bottom:20px;

}

.price{

font-size:38px;

font-weight:bold;

color:#228B22;

margin-bottom:25px;

}

/*===================== QUANTITY =====================*/

.quantity{

display:flex;

align-items:center;

gap:10px;

}

.qty-btn{

width:42px;

height:42px;

background:#9f531b;

color:white;

border-radius:8px;

display:flex;

justify-content:center;

align-items:center;

text-decoration:none;

font-size:24px;

font-weight:bold;

transition:.3s;

}

.qty-btn:hover{

background:#823513;

}

.qty-box{

width:70px;

height:42px;

border:1px solid #ccc;

display:flex;

justify-content:center;

align-items:center;

font-size:20px;

border-radius:8px;

background:white;

}

.remove{

margin-left:25px;

text-decoration:none;

color:#d62828;

font-weight:600;

font-size:17px;

transition:.3s;

}

.remove:hover{

color:red;

}

/*===================== SUMMARY =====================*/

.summary{

width:90%;

margin:35px auto;

background:white;

padding:30px;

border-radius:18px;

box-shadow:0 10px 25px rgba(0,0,0,.08);

}

.summary h2{

text-align:center;

color:#823513;

font-size:34px;

margin-bottom:20px;

position:relative;

}

.summary h2::after{

content:"";

display:block;

width:140px;

height:2px;

background:#faae33;

margin:10px auto;

}

.row{

display:flex;

justify-content:space-between;

font-size:22px;

margin:20px 0;

color:#444;

}

.grand{

font-size:34px;

font-weight:bold;

color:#228B22;

}

/*===================== BUTTONS =====================*/

.buttons{

width:90%;

margin:25px auto 60px;

display:flex;

gap:25px;

}

.btn{

flex:1;

padding:18px;

text-decoration:none;

text-align:center;

font-size:22px;

font-weight:bold;

border-radius:12px;

transition:.3s;

}

.continue{

background:#823513;

color:white;

}

.continue:hover{

background:#6e2d10;

}

.checkout{

background:#faae33;

color:#823513;

}

.checkout:hover{

background:#ffbe45;

}

/*===================== EMPTY CART =====================*/

.empty{

text-align:center;

margin-top:140px;

}

.empty h2{

font-size:42px;

color:#823513;

margin-bottom:20px;

}

.empty p{

font-size:22px;

color:#666;

margin-bottom:30px;

}

.empty a{

padding:16px 35px;

background:#823513;

color:white;

text-decoration:none;

border-radius:10px;

font-size:20px;

font-weight:bold;

}

.empty a:hover{

background:#9f531b;

}

.footer{

text-align:center;

padding:20px;

color:#777;

font-size:16px;

}


.qty-btn{

    width:38px;

    height:38px;

    display:flex;

    justify-content:center;

    align-items:center;

    background:#9f531b;

    color:white;

    text-decoration:none;

    font-size:24px;

    font-weight:bold;

    border-radius:8px;

    transition:.3s;

}

.qty-btn:hover{

    background:#6d2d0c;

}



.qty-box{

    width:52px;

    height:38px;

    display:flex;

    justify-content:center;

    align-items:center;

    border:1px solid #ddd;

    border-radius:8px;

    font-size:18px;

    background:white;

}




.remove{

    margin-left:25px;

    color:#d62828;

    text-decoration:none;

    font-size:16px;

    font-weight:600;

}

.remove:hover{

    color:red;

}


</style>

</head>

<body>

<nav class="navbar">

<div class="logo">

QuickBite

</div>

<div class="nav-links">

<%@ page import="com.tap.model.User" %>

<%
User loggedInUser =
(User)session.getAttribute("loggedInUser");
%>

<div class="nav-links">

<a href="restaurants">Restaurants</a>

<%

if(loggedInUser==null){

%>

<a href="Login.jsp">Login</a>

<%

}else{

%>

<a href="Profile.jsp">Profile</a>

<%

}

%>

</div>
</div>

</nav>

<div class="heading">

<h1>My Cart</h1>

<div class="line"></div>

</div>

<div class="info">

🍽️ Items from one restaurant only

</div>

<%

Cart cart=(Cart)session.getAttribute("cart");

if(cart!=null && !cart.isEmpty()){

Collection<CartItem> items=cart.getItems();

%>

<div class="container">






<%

for(CartItem item : items){

%>

<div class="card">

    <img src="<%=item.getMenu().getImagePath()%>"
         alt="<%=item.getMenu().getItemName()%>">

    <div class="details">

        <div class="name">
            <%=item.getMenu().getItemName()%>
        </div>

        <div class="description">
            <%=item.getMenu().getDescription()%>
        </div>

        <div class="price">

            ₹ <%=String.format("%.2f",
                    item.getMenu().getPrice())%>

        </div>

        <div class="quantity">

            <!-- Minus Button -->

            <a class="qty-btn"
               href="cart?action=update&menuId=<%=item.getMenu().getMenuID()%>&quantity=<%=item.getQuantity()-1%>">

                −

            </a>

            <!-- Quantity -->

            <div class="qty-box">

                <%=item.getQuantity()%>

            </div>

            <!-- Plus Button -->

            <a class="qty-btn"
               href="cart?action=update&menuId=<%=item.getMenu().getMenuID()%>&quantity=<%=item.getQuantity()+1%>">

                +

            </a>

            <!-- Remove -->

            <a class="remove"
               href="cart?action=remove&menuId=<%=item.getMenu().getMenuID()%>">

                🗑 Remove

            </a>

        </div>

    </div>

</div>

<%

}

%>

</div>

<div class="summary">

<h2>

Cart Summary

</h2>

<div class="row">

<span>

Total Items

</span>

<span>

<%=cart.getTotalItems()%>

</span>

</div>

<hr style="border:1px dashed #ddd; margin:18px 0;">

<div class="row grand">

<span>

Grand Total

</span>

<span>

₹ <%=String.format("%.2f",
        cart.getTotalPrice())%>

</span>

</div>

</div>

<div class="buttons">

<a href="restaurants"
class="btn continue">

⬅ Add More Items

</a>

<a href="checkout"
class="btn checkout">

🛍 Proceed To Checkout

</a>



<%

}

else{

%>

<div class="empty">

    <h2>

        🛒 Your Cart is Empty

    </h2>

    <p>

        Looks like you haven't added any delicious food yet.

    </p>

    <a href="restaurants">

        🍽 Browse Restaurants

    </a>

</div>

<%

}

%>

<div class="footer">

    Thank you for choosing
    <b style="color:#823513;">QuickBite</b>.
    Happy Ordering!
    ❤️

</div>

</body>

</html>