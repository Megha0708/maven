<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<script src="resources/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>


<script>
   
	var prod1 = ${mylist1};
	var prod2 = ${mylist2};
	var prod3 = ${mylist3};
	angular.module('repeatSample', []).controller('repeatController',
			function($scope) {
		       
				$scope.mylist1 = prod1;
				$scope.mylist2 = prod2;
				$scope.mylist3 = prod3;
				$scope.sort = function(keyname) {
					$scope.sortKey = keyname; //set the sortKey to the param passed
					$scope.reverse = !$scope.reverse; //if true make it false and vice versa
				}
			});
	</script>
	<script>
	var pro=${poc};
	angular.module('repeatS', []).controller('repeatC',
			function($scope) {
		       
				$scope.poc = pro;
				
				
				
			});
</script>



</head>
<body  class="container" >

<c:if test="${(checkk==3)}">
 <div ng-app="repeatS"  ng-controller="repeatC" >
 
 <div ng-repeat="product in poc">
 <center><img src="./resources/images/{{product.pid}}.jpg" height="450px" width="500px"></center>
 </div> 
    
 <center>   
<table class="table table-responsive" ng-repeat="product in poc">
<tr>
                <td><b>product id</b></td>
                 <td></td>
                <td>{{product.pid}}</td>
             </tr>
              <tr>
                <td><b>product name</b></td>
                 <td></td>
                <td>{{product.name}}</td>
              </tr>
              <tr>
                 <td><b> price</b></td>
                  <td></td>
                 <td>{{product.price}}</td>
              </tr>
              <tr>
                 <td><b> Stock</b></td>
                <td></td>
                 <td>{{product.stock}}</td>
              </tr>
              
                <tr>
                   <td><b>Description</b></td>
                   <td></td>
                   <td>{{product.description}}</td>
                </tr>
                
                
</table>
</center>
<br> 
<div ng-repeat="product in poc">
<center>
<a  href="Carddetails?pid={{product.pid}}"><button >Add to Cart</button></a>

<a  href="categoryregister"><button >Buy Now</button></a>
</center>
</div>
</div>
</c:if>
<div ng-app="repeatSample"  ng-controller="repeatController" >

 <c:if test="${checkk==1}">

 
    
			<sf:form role="form" action="Insertproduct" commandName="product" method="post" modelAttribute="product"  enctype="multipart/form-data">
				<h2>
					ADD PRODUCTS
				</h2>
				
				<sf:input type="file" path="pimage" class="form-control input-lg" 
                                 placeholder="file" tabindex="1" 
									title="minimum length for ProductDiscription is 1"/>
									<br><br>
									
			
							<sf:input path="name"
									class="form-control input-lg" placeholder="productname"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for productname is 5"></sf:input>
						
						<sf:input path="price"
									class="form-control input-lg" placeholder="price"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for prize is 1"></sf:input>

					<sf:input path="stock"
									class="form-control input-lg" placeholder="stock"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for stock is 1"></sf:input>
			
				<br><br>
				<sf:input path="description"
									class="form-control input-lg" placeholder="description"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for ProductDiscription is 1"></sf:input>
					
			<br><br>
			
			  <sf:label path="cat_id">category Id</sf:label>
			  <sf:select path="cat_id" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist1" value="{{product.id}}">{{product.id}}</option>
			  </sf:select>
			   
			      
			  <sf:label path="sup_id">supplier id</sf:label>
			  <sf:select path="sup_id" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist2" value="{{product.id}}">{{product.id}}</option>
			  </sf:select>
		
			   <sf:label path="supplier">supplier Name</sf:label>
			  <sf:select path="supplier" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist2" value="{{product.name}}">{{product.name}}</option>
			  </sf:select>
			   
			   <br> <br>
			   
				<input type="submit" value="AddProducts"
				class="btn btn-primary btn-block btn-lg" tabindex="7">
				
	   
									
			</sf:form>
	
</c:if>

<c:if test="${(checkk==2)}">

<sf:form role="form" action="plzNowUpdatedproducts" commandName="product" method="post" >
				<h2>
					Update
				</h2>
						   <sf:input type="file" path="pimage" class="form-control input-lg" 
                                 placeholder="file" tabindex="1" 
									title="minimum length for ProductDiscription is 1"/>
									
						
				
						<sf:input path="pid"
									class="form-control input-lg" placeholder="productid"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for productid is 5"></sf:input>
						
							<sf:input path="name"
									class="form-control input-lg" placeholder="productname"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for productname is 5"></sf:input>
						
						<sf:input path="price"
									class="form-control input-lg" placeholder="prize"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for prize is 1"></sf:input>

					
					
					<sf:input path="stock"
									class="form-control input-lg" placeholder="stock"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for stock is 1"></sf:input>
				
		
				<sf:input path="description"
									class="form-control input-lg" placeholder="discrption"
									tabindex="1" pattern=".{1,15}" required="true"
									title="minimum length for ProductDiscription is 1"></sf:input>
									
			
			   
			 <sf:label path="cat_id">category Id</sf:label>
			  <sf:select path="cat_id" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist1" value="{{product.id}}">{{product.id}}</option>
			  </sf:select>
			   
			      
			  <sf:label path="sup_id">supplier id</sf:label>
			  <sf:select path="sup_id" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist2" value="{{product.id}}">{{product.id}}</option>
			  </sf:select>
		
			   <sf:label path="supplier">supplier Name</sf:label>
			  <sf:select path="supplier" class="form-control input-sm" ng-controller="repeatController">
			  <option ng-repeat="product in mylist2" value="{{product.name}}">{{product.name}}</option>
			  </sf:select>
			   
			
									
			   
			
									
			   
				<input type="submit" value="Update Product"
				class="btn btn-primary btn-block btn-lg" tabindex="7">
				   
									
			</sf:form>
		


</c:if>





<c:if test="${(checkk==1)||(checkk==2)}">
<div  >

<br>

<h2 align="center">Search Products</h2>
<input type="text" class="search-query form-control" placeholder="Search" ng-model="searchText" />



<table class="table table-responsive" >
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
				<tr ng-repeat="product in mylist3|filter:searchText">
				<td><a href="productDescription?pid={{product.pid}}">{{product.pid}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.name}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.price}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.stock}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.description}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.cat_id}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}">{{product.sup_id}}</a></td>
				    <td><a href="productDescription?pid={{product.pid}}">{{product.supplier}}</a></td>
					<td><a href="productDescription?pid={{product.pid}}"><img src="./resources/images/{{product.pid}}.jpg" height="50px" width="50px"></a></td>
                 
                     <td><a href="plzUpdatedproduct?pid={{product.pid}}">update</a></td>
                     <td><a href="Deleteproduct?pid={{product.pid}}">Delete</a></td>

</tr>
</table>

</div>
</c:if>
</div>
</body>
</html>