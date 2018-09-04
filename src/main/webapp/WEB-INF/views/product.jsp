<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="/webstore/resource/js/controllers.js"></script>
<title>Product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Product</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
			<div class="col-md-5">
				<img
					src="<c:url value="/resource/images/${product.productId}.jpg"></c:url>"
					alt="image" style="width: 100%" />
			</div>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>
					<strong>Manufacturer: </strong>${product.manufacturer}
				</p>
				<p>
					<strong>Category: </strong>${product.category}
				</p>
				<p>
					<strong>Units in stock: </strong>${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}PLN</h4>
				<p ng-controller="cartCtrl">
				
					<a href="<spring:url value="/products" />" class="btn btndefault">
						<span class="glyphicon-hand-left glyphicon"></span>Back
					</a>
					
					 <a href="#" class="btn btn-warning btn-large"
						ng-click="addToCart('${product.productId}')"> 
						<span class="glyphicon-shopping-cart glyphicon"></span> Add to basket
					</a>
					
					 <a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span> Basket
					</a>
					
				</p>
			</div>
		</div>
	</section>
</body>
</html>