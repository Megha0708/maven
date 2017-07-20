<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="resources/My_Design/angular.min.js"></script>



<script>
	var prod = ${mylist3};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
				$scope.products = prod;

				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}

			});
</script>


<body ng-app="repeatSample" ng-controller="repeatController">
		
		

		
					<h2 align="center">Search And see Products</h2>

					<input type="text" class="search-query form-control"
						placeholder="please Search all products" ng-model="searchText" />

				
			
<table class="table table-responsive" ng-repeat="product in products|filter:searchText" >
<thead>
					<tr>
						<th>product id</th>

						<th>product name  </th>
						<th>price   </th>
						<th>stock  </th>
						<th>description  </th>
						<th>category id  </th>
						<th>supplier id  </th>
						<th>supplier  </th>
						<th>Image  </th>
					</tr>
				</thead>
				<tr >
				<td><a href="productDescription?pid={{product.pid}}">{{product.pid}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.name}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.price}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.stock}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.description}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.cat_id}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.sup_id}}</a></td>
				    <td><a href="productDescription?pid={{product.pid}}">{{product.supplier}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}"><img src="./resources/images/{{product.pid}}.jpg" height="50px" width="50px"></a></td>
                 
                    

</tr>
</table>

</body>








