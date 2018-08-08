<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix ="spring" uri="http://www.springframework.org/tags"%>

<spring:url var = "css" value ="/resources/css"/>
<spring:url var = "js" value ="/resources/js"/>
<spring:url var = "img" value ="/resources/img"/>
<!DOCTYPE html>
<html lang="en">
 <head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="${img}/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${css}/core-style.css">
    
    

</head>
<body>
 <header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="${contextRoot}/fbs/"><img src="${img}/core-img/logo.png" alt=""></a>
            </div>
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                    <li class="active"><a href="${contextRoot}/fbs/">Home</a></li>
                    <li><a href="${contextRoot}/fbs/shop">Shop</a></li>
                    <li><a href="${contextRoot}/fbs/cart">Cart</a></li>
                    <li><a href="${contextRoot}/fbs/checkout">Checkout</a></li>
                  
                </ul>
            </nav>
            <!-- Button Group -->
            <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div>
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="cart.html" class="cart-nav"><img src="${img}/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
                <a href="#" class="fav-nav"><img src="${img}/core-img/favorites.png" alt=""> Favourite</a>
                <a href="#" class="search-nav"><img src="${img}/core-img/search.png" alt=""> Search</a>
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="https://www.facebook.com/haminhduchedspi"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->
         <script src="${js}/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${js}/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${js}/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="${js}/plugins.js"></script>
    <!-- Active js -->
    <script src="${js}/active.js"></script>
</body>
</html>