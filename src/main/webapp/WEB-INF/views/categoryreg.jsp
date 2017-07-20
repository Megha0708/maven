<html>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="resources/angular.min.js"></script>
<script>
	var prod = ${mylist};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.products = prod;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>

</head>
<body class="container" ng-app="repeatSample" ng-controller="repeatController">

<c:if test="${!checkk}">


	
		
			<sf:form role="form" action="InsertCategory" commandName="category">
				<h2>
					Please See the all Categortes...<small>It's free and always
						will be.</small>
				</h2>
			
								<sf:input path="name" class="form-control input-lg"
									placeholder="categoryName" tabindex="1" pattern=".{3,15}"
									required="true" title="minimum length for categoryName is 5"></sf:input>
							
								<sf:input path="sup_id" class="form-control input-lg"
									placeholder="supplier id" tabindex="1" pattern=".{1,15}"
									required="true" title="minimum length for supplier id is 1"></sf:input>
							
							
								<sf:input path="sup_name" class="form-control input-lg"
									placeholder="supplier name" tabindex="1" pattern=".{1,15}"
									required="true" title="minimum length for supplier name is 1"></sf:input>
							
							
							
								
								<input type="submit" value="Add-Category"
									class="btn btn-primary btn-block btn-lg" tabindex="7">
							
						
			</sf:form>

	
</c:if>


			

			
					<h2 align="center">Search Category</h2>

			<input type="text" class="search-query form-control" placeholder="Search" ng-model="searchText" />

				

			<table class="table table-responsive">


				<thead>
					<tr>
						<th>Category Id</th>
						<th>category Name</th>
						<th>Supplier Id</th>
						<th>Supplier Name</th>
					</tr>
				</thead>

				

				<tr ng-repeat="product in products|filter:searchText">


					<td>{{product.id}}</td>
					<td>{{product.name}}</td>
					<td>{{product.sup_id}}</td>
					<td>{{product.sup_name}}</td>
					


				</tr>
			</table>
		



</body>
</html>