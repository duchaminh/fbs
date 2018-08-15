<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado-Ecommercce</title>

<!-- Favicon  -->
<link rel="icon" href="${img}/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="${css}/core-style.css">
</head>
<body>
	<!-- Search Wrapper Area Start -->
	<div class="search-wrapper section-padding-100">
		<div class="search-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="search-content">
						<h4>test123</h4>
						<form action="#" method="get">
							<input type="search" name="search" id="search"
								placeholder="Type your keyword...">
							<button type="submit">
								<img src="${img}/core-img/search.png" alt="">
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Search Wrapper Area End -->


	<div class="main-content-wrapper d-flex clearfix">

		<!-- Mobile Nav (max width 767px)-->
		<div class="mobile-nav">
			<!-- Navbar Brand -->
			<div class="amado-navbar-brand">
				<a href="index.html"><img src="${img}/core-img/logo.png" alt=""></a>
			</div>
			<!-- Navbar Toggler -->
			<div class="amado-navbar-toggler">
				<span></span><span></span><span></span>
			</div>
		</div>

		<!-- Header Area Start -->
		<%@include file="./shared/head_area.jsp"%>

		<!-- Product management Area Start -->

		<div class="products-catagories-area clearfix">
			<div class="amado-pro-catagory clearfix">
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-xs-12 col-md-offset-2 col-md-8">
							<div class="alert alert-info fade in">${message}</div>
						</div>
					</div>
				</c:if>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4></h4>
					</div>
					<div class="panel-heading">
						<h4></h4>
					</div>
					<div class="panel-heading">
						<br> <br> <br> <br>
						<h4>Product Management</h4>
					</div>
					<div class="panel-body">
						<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/fbs/manage/product" method="POST">
							<div class="form-group">
								<label class="control-label col-md-4">Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="name" class="form-control"
										placeholder="Product Name" />
									<sf:errors path="name" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Brand</label>
								<div class="col-md-8">
									<sf:input type="text" path="brand" class="form-control"
										placeholder="Brand Name" />
									<sf:errors path="brand" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Description</label>
								<div class="col-md-8">
									<sf:textarea path="description" class="form-control"
										placeholder="Enter your description here!" />
									<sf:errors path="description" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Unit Price</label>
								<div class="col-md-8">
									<sf:input type="number" path="unitPrice" class="form-control"
										placeholder="Enter Unit Price" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Quantity</label>
								<div class="col-md-8">
									<sf:input type="number" path="quantity" class="form-control"
										placeholder="Enter Quantity" />
									<sf:errors path="quantity" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Category</label>
								<div class="col-md-8">
									<sf:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control"/>

									<div class="text-right">
										<br>
										<sf:hidden path="id" />
										<sf:hidden path="code" />
										<sf:hidden path="supplierId" />
										<sf:hidden path="active" />
										
									</div>
								</div>

							</div>
							
							<div class="form-group">
							
								<div class="col-md-offset-4 col-md-4">
								
									<input type="submit" name="submit" value="Save" class="btn btn-primary"/>
									
								</div>
							</div>	
							
						</sf:form>
				

					</div>
				</div>
			</div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Category</h4>
				</div>
				<div class="modal-body">

					<sf:form id="categoryForm" class="form-horizontal"
						modelAttribute="category" action="${contextRoot}/manage/category"
						method="POST">

						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Category Name" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8 validate">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter category description here!" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
			
			
	</div>
	<%@include file="./shared/newsletter.jsp"%>
	<!-- ##### Footer Area Start ##### -->
	<%@include file="./shared/footer.jsp"%>

	
	<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
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