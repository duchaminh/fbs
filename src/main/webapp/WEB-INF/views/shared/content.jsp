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
    <title>Amado Shop</title>

    <!-- Favicon  -->
    <link rel="icon" href="${img}/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${css}/style.css">

</head>

<body>
<div class="products-catagories-area clearfix">
	<div class="amado-pro-catagory clearfix">

		<!-- Single Catagory -->
		<c:forEach items = "${products}" var = "product">
		<div class="single-products-catagory clearfix">
				<a href="${contextRoot}/fbs/show/${product.id}/product"> <img src="${img}/product-img/${product.code}.jpg">
				<div class="hover-content">
					<div class="line"></div>
					<p>${product.name}</p>
				</div>
			</a>
		</div>
		</c:forEach> 
	</div>
</div>
</body>
</html>
<!-- Product Catagories Area End -->