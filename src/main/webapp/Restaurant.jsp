<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.DAOImpl.RestaurantDAOImpl" %>
<%
User loggedInUser =
(User)session.getAttribute("loggedInUser");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>QuickBite - Restaurants</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    background:#fffaf3;
}

/* ================= NAVBAR ================= */

.navbar{
    background:#823513;
    height:85px;

    display:flex;
    justify-content:space-between;
    align-items:center;

    padding:0 40px;

    position:sticky;
    top:0;
    z-index:1000;

    box-shadow:0 4px 15px rgba(0,0,0,0.15);
}

.logo-section{
    display:flex;
    align-items:center;
    gap:12px;
}

.logo-img{
    width:60px;
    height:60px;
    object-fit:contain;
}

.logo-text{
    font-size:30px;
    font-weight:700;
    color:#faae33;
    letter-spacing:1px;
}

.search-bar{
    flex:1;
    max-width:450px;
    margin:0 40px;
}

.search-bar input{
    width:100%;
    padding:12px 18px;

    border:none;
    outline:none;

    border-radius:30px;

    font-size:15px;
}

.nav-links{
    display:flex;
    align-items:center;
    gap:25px;
}

.nav-links a{
    text-decoration:none;
    color:white;

    font-size:16px;
    font-weight:600;

    transition:0.3s;
}

.nav-links a:hover{
    color:#faae33;
}














/* ================= NAVBAR ================= */

.navbar{

background:#823513;

height:85px;

display:flex;

justify-content:space-between;

align-items:center;

padding:0 40px;

position:sticky;

top:0;

z-index:1000;

box-shadow:0 4px 15px rgba(0,0,0,.15);

}

.logo-section{

display:flex;

align-items:center;

gap:12px;

}

.logo-img{

    width:55px;

    height:55px;

    object-fit:cover;

    border-radius:50%;

    overflow:hidden;

    border:2px solid #faae33;   /* Optional border */

}

.logo-text{

font-size:30px;

font-weight:bold;

color:#faae33;

}

.search-bar{

flex:1;

margin:0 50px;

}

.search-bar input{

width:100%;

padding:12px 20px;

border:none;

border-radius:30px;

outline:none;

font-size:16px;

}

.nav-links{

display:flex;

align-items:center;

gap:25px;

margin-left:auto;

}

.nav-links a{

color:white;

text-decoration:none;

font-size:17px;

font-weight:bold;

transition:.3s;

}

.nav-links a:hover{

color:#faae33;

}

/* Dropdown */

.dropdown{

position:relative;

display:inline-block;

}

.dropbtn{

background:none;

border:none;

color:#faae33;

font-size:17px;

font-weight:bold;

cursor:pointer;

}

.dropdown-content{

display:none;

position:absolute;

right:0;

background:white;

min-width:190px;

border-radius:10px;

box-shadow:0 10px 25px rgba(0,0,0,.15);

overflow:hidden;

z-index:1000;

}

.dropdown-content a{

display:block;

padding:14px 18px;

color:#333;

text-decoration:none;

font-size:16px;

}

.dropdown-content a:hover{

background:#faae33;

color:#823513;

}

.dropdown:hover .dropdown-content{

display:block;

}




.navbar{

    background:#823513;

    height:100px;

    display:flex;

    align-items:center;

    padding:0 40px;

    position:sticky;

    top:0;

    z-index:1000;

    box-shadow:0 4px 15px rgba(0,0,0,.15);

}




.logo-section{

    display:flex;

    align-items:center;

    gap:12px;

    width:280px;

}


.search-bar{

    flex:1;

    display:flex;

    justify-content:center;

}


.search-bar input{

    width:550px;

    max-width:100%;

    padding:13px 22px;

    border:none;

    outline:none;

    border-radius:35px;

    font-size:17px;

}


.nav-links{

    width:350px;

    display:flex;

    justify-content:flex-end;

    align-items:center;

    gap:25px;

}
/* ================= HERO ================= */

.hero{

    background:linear-gradient(
    135deg,
    #823513,
    #9f531b);

    color:white;

    text-align:center;

    padding:90px 20px;
}

.hero h1{
    font-size:48px;
    margin-bottom:15px;
}

.hero p{
    font-size:20px;
    margin-bottom:25px;
}

.order-btn{

    display:inline-block;

    text-decoration:none;

    background:#faae33;
    color:#823513;

    padding:14px 28px;

    border-radius:30px;

    font-weight:bold;

    transition:0.3s;
}

.order-btn:hover{

    background:white;
}

/* ================= SECTION TITLE ================= */

.section-title{

    text-align:center;

    margin:50px 0 30px;

    color:#823513;

    font-size:40px;
}

/* ================= RESTAURANT GRID ================= */

.container{

    width:90%;

    margin:0 auto 60px;

    display:grid;

    grid-template-columns:
    repeat(auto-fit,minmax(320px,1fr));

    gap:30px;
}

/* ================= CARD ================= */

.card{

    background:white;

    border-radius:20px;

    overflow:hidden;

    box-shadow:
    0 8px 20px rgba(0,0,0,0.10);

    transition:all .4s ease;
}

.card:hover{

    transform:translateY(-10px);

    box-shadow:
    0 18px 35px rgba(0,0,0,0.18);
}

.card img{

    width:100%;

    height:240px;

    object-fit:cover;

    transition:0.5s;
}

.card:hover img{

    transform:scale(1.05);
}

.content{

    padding:20px;
}

.name{

    font-size:24px;

    font-weight:700;

    color:#823513;

    margin-bottom:12px;
}

.rating{

    display:inline-block;

    background:#eaf8ee;

    color:#0c8a41;

    padding:6px 12px;

    border-radius:20px;

    font-weight:bold;

    margin-bottom:12px;
}

.cuisine{

    color:#555;

    margin-bottom:10px;

    font-size:15px;
}

.delivery{

    color:#444;

    margin-bottom:10px;

    font-weight:500;
}

.address{

    color:#777;

    line-height:1.5;

    min-height:50px;
}

/* ================= BUTTON ================= */

.menu-btn{

    display:block;

    width:100%;

    margin-top:18px;

    padding:14px;

    text-align:center;

    text-decoration:none;

    background:#faae33;

    color:#823513;

    border-radius:12px;

    font-size:16px;

    font-weight:bold;

    transition:0.3s;
}

.menu-btn:hover{

    background:#9f531b;

    color:white;
}

/* ================= RESPONSIVE ================= */

@media(max-width:900px){

    .navbar{

        flex-direction:column;

        height:auto;

        padding:15px;
        gap:15px;
    }

    .search-bar{

        width:100%;
        max-width:100%;
        margin:0;
    }

    .hero h1{

        font-size:36px;
    }

    .section-title{

        font-size:30px;
    }
}



</style>

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar">

<nav class="navbar">

    <!-- Logo -->

    <div class="logo-section">

        <img src="images/logo.jpg"
             class="logo-img"
             alt="QuickBite">

        <span class="logo-text">

            QuickBite

        </span>

    </div>

    <!-- Search Bar -->

  <div class="search-bar">

<form action="restaurants" method="get">

<input
    type="text"
    name="search"
    placeholder="Search restaurants..."
    value="<%= request.getParameter("search") == null ? "" : request.getParameter("search") %>"
    onkeyup="this.form.submit()">

</form>

</div>
    <!-- Right Side -->

    <div class="nav-links">

<%

if(loggedInUser == null){

%>

    <a href="Login.jsp">

        Login

    </a>

    <a href="Register.jsp">

        Register

    </a>

    <a href="Cart.jsp">

        🛒 Cart

    </a>

<%

}else{

%>

    <div class="dropdown">

        <button class="dropbtn">

            👤 Welcome,

            <%=loggedInUser.getUserName()%> ▼

        </button>

        <div class="dropdown-content">

            <a href="profile">

                👤 Profile

            </a>

            <a href="myOrders">

                📦 My Orders

            </a>

            <a href="logout">

                🚪 Logout

            </a>

        </div>

    </div>

    <a href="Cart.jsp">

        🛒 Cart

    </a>

<%

}

%>

</div>

</nav>



</nav>

<!-- ================= HERO SECTION ================= -->

<section class="hero">

<h1>Welcome to QuickBite</h1>

<p>
    Fresh Food Delivered To Your Doorstep
</p>

<a href="#restaurants" class="order-btn">
    Order Now
</a>


</section>

<!-- ================= RESTAURANTS ================= -->

<h2 class="section-title" id="restaurants">
    Available Restaurants
</h2>

<div class="container">

<%
List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurants");

if(restaurantList != null){

    for(Restaurant r : restaurantList){

%>

<div class="card">

<img
src="<%= request.getContextPath() %>/<%= r.getImagePath() %>"
alt="<%= r.getName() %>">
     
   
     

<div class="content">

    <div class="name">
        <%= r.getName() %>
    </div>

    <div class="rating">
        ⭐ <%= r.getRating() %>
    </div>

    <div class="cuisine">
        🍽️ <%= r.getCuisineType() %>
    </div>

    <div class="delivery">
        🕒 <%= r.getDeliveryTime() %> mins
    </div>

    <div class="address">
        📍 <%= r.getAddress() %>
    </div>

    <a href="menu?restaurantId=<%= r.getRestaurantID() %>"
       class="menu-btn">

       Show Menu

    </a>

</div>

</div>

<%
}
}
else{
%>

<h2 style="text-align:center;color:#823513;">
    No Restaurants Found
</h2>

<%
}
%>

</div>

</body>
</html>
