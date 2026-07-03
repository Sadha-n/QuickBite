<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>QuickBite | Restaurant Menu</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',Tahoma,Geneva,Verdana,sans-serif;
}

body{
    background:#fffaf3;
}

/* ================= NAVBAR ================= */

.navbar{

    height:85px;

    background:#823513;

    display:flex;

    justify-content:space-between;

    align-items:center;

    padding:0 50px;

    position:sticky;

    top:0;

    z-index:999;

    box-shadow:0 4px 15px rgba(0,0,0,.15);
}

.logo{

    color:#faae33;

    font-size:34px;

    font-weight:bold;
}

.nav-links{

    display:flex;

    gap:30px;
}

.nav-links a{

    color:white;

    text-decoration:none;

    font-size:18px;

    font-weight:600;

    transition:.3s;
}

.nav-links a:hover{

    color:#faae33;
}

/* ================= TITLE ================= */

.heading{

    text-align:center;

    margin-top:40px;

    color:#823513;

    font-size:54px;

    font-weight:bold;
}

.heading::after{

    content:"";

    width:180px;

    height:4px;

    background:#faae33;

    display:block;

    margin:18px auto;

    border-radius:10px;
}

/* ================= SEARCH ================= */

.search{

    width:40%;

    margin:35px auto;
}

.search input{

    width:100%;

    padding:16px 22px;

    border-radius:40px;

    border:2px solid #faae33;

    outline:none;

    font-size:17px;

    transition:.3s;
}

.search input:focus{

    box-shadow:0 0 15px rgba(250,174,51,.4);
}

/* ================= GRID ================= */

.container{

    width:92%;

    margin:40px auto;

    display:grid;

    grid-template-columns:repeat(auto-fit,minmax(500px,1fr));

    gap:35px;
}

/* ================= CARD ================= */

.card{

    background:white;

    border-radius:22px;

    overflow:hidden;

    box-shadow:0 12px 30px rgba(0,0,0,.12);

    transition:.35s;
}

.card:hover{

    transform:translateY(-8px);

    box-shadow:0 20px 45px rgba(0,0,0,.18);
}

/* ================= IMAGE ================= */

.image-section{

    width:100%;

    height:290px;

    overflow:hidden;
}

.image-section img{

    width:100%;

    height:100%;

    object-fit:cover;

    object-position:center;

    transition:.45s;
}

.card:hover img{

    transform:scale(1.08);
}

/* ================= CONTENT ================= */

.content{

    padding:25px;
}

.itemName{

    color:#823513;

    font-size:34px;

    font-weight:bold;

    margin-bottom:12px;
}

.description{

    color:#666;

    font-size:18px;

    line-height:1.6;

    margin-bottom:20px;

    min-height:55px;
}

.price{

    color:#1c8d2c;

    font-size:34px;

    font-weight:bold;

    margin-bottom:22px;
}

/* ================= BUTTON ================= */

.btn{

    width:100%;

    padding:17px;

    border:none;

    border-radius:14px;

    background:#faae33;

    color:#823513;

    font-size:20px;

    font-weight:bold;

    cursor:pointer;

    transition:.3s;
}

.btn:hover{

    background:#823513;

    color:white;
}

/* ================= RESPONSIVE ================= */

@media(max-width:900px){

.navbar{

padding:20px;

flex-direction:column;

height:auto;

gap:18px;

}

.search{

width:90%;

}

.container{

grid-template-columns:1fr;

}

.heading{

font-size:40px;

}

.image-section{

height:240px;

}

.itemName{

font-size:28px;

}

.price{

font-size:28px;

}

}

</style>

</head>

<body>

<nav class="navbar">

<div class="logo">
QuickBite
</div>

<div class="nav-links">

<a href="restaurants">
Restaurants
</a>

<a href="Cart.jsp">
Cart 🛒
</a>

</div>

</nav>

<h1 class="heading">
Restaurant Menu
</h1>

<div class="search">

<input
type="text"
placeholder="Search Food Item...">

</div>

<div class="container">

<%

List<Menu> menuList =
(List<Menu>)request.getAttribute("menuList");

if(menuList!=null){

for(Menu m:menuList){

%>







<div class="card">

    <!-- ================= IMAGE ================= -->

    <div class="image-section">

        <img src="<%=m.getImagePath()%>"
             alt="<%=m.getItemName()%>">

    </div>

    <!-- ================= CONTENT ================= -->

    <div class="content">

        <div class="itemName">

            <%=m.getItemName()%>

        </div>

        <div class="description">

            <%=m.getDescription()%>

        </div>

        <div class="price">

            ₹ <%=String.format("%.2f",m.getPrice())%>

        </div>

        <form action="cart" method="post">

            <input
                type="hidden"
                name="menuId"
                value="<%=m.getMenuID()%>">

            <input
                type="hidden"
                name="restaurantId"
                value="<%=m.getRestaurantID()%>">

            <input
                type="hidden"
                name="action"
                value="add">

            <button class="btn">

                🛒 Add To Cart

            </button>

        </form>

    </div>

</div>

<%

}

}else{

%>

<div style="width:100%;
            text-align:center;
            font-size:28px;
            color:#823513;
            padding:100px;">

    No Menu Available

</div>

<%

}

%>


</div>

<!-- ================= FOOTER ================= -->

<footer class="footer">

    <p>
        © 2026 <b>QuickBite</b> |
        Fresh Food, Fast Delivery 🚀
    </p>

</footer>

<style>

.footer{

    margin-top:60px;

    background:#823513;

    color:white;

    text-align:center;

    padding:25px;

    font-size:18px;

}

.footer b{

    color:#faae33;

}

</style>

<!-- ================= SEARCH SCRIPT ================= -->

<script>

const searchBox =
document.querySelector(".search input");

const cards =
document.querySelectorAll(".card");

searchBox.addEventListener("keyup",function(){

    let value =
    this.value.toLowerCase();

    cards.forEach(card=>{

        let itemName =
        card.querySelector(".itemName")
        .innerText
        .toLowerCase();

        let description =
        card.querySelector(".description")
        .innerText
        .toLowerCase();

        if(itemName.includes(value) ||
           description.includes(value)){

            card.style.display="block";

        }
        else{

            card.style.display="none";

        }

    });

});

</script>

</body>

</html>











