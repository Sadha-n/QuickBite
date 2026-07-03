<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.CartItem"%>

<%

CartItem item = (CartItem)request.getAttribute("cartItem");

if(item!=null){

%>

<div class="card">

    <div class="image-section">

        <img src="<%=item.getMenu().getImagePath()%>"
             alt="<%=item.getMenu().getItemName()%>">

    </div>

    <div class="details">

        <h2 class="item-name">

            <%=item.getMenu().getItemName()%>

        </h2>

        <p class="description">

            <%=item.getMenu().getDescription()%>

        </p>

        <h3 class="price">

            ₹ <%=String.format("%.2f",item.getMenu().getPrice())%>

        </h3>

        <div class="quantity-section">

            <a class="qty-btn"
               href="cart?action=update&menuId=<%=item.getMenu().getMenuID()%>&quantity=<%=item.getQuantity()-1%>">

                -

            </a>

            <span class="qty">

                <%=item.getQuantity()%>

            </span>

            <a class="qty-btn"
               href="cart?action=update&menuId=<%=item.getMenu().getMenuID()%>&quantity=<%=item.getQuantity()+1%>">

                +

            </a>

            <a class="remove-btn"
               href="cart?action=remove&menuId=<%=item.getMenu().getMenuID()%>">

                🗑 Remove

            </a>

        </div>

        <div class="total">

            Item Total :
            <span>

                ₹ <%=String.format("%.2f",item.getItemTotal())%>

            </span>

        </div>

    </div>

</div>

<%

}

%>