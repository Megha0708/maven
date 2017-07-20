<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
<c:choose>
<c:when test="${empty count}">
List is empty!!
</c:when>
<c:otherwise>
<sf:form class="form-horizontal" method="get" action="updateqty">
<table class="table table-bordered table-hover table-striped">
<thead>
					<tr>
						
                        <th>Image</th>
                        <th>productname</th>
						<th>Quantity</th> 
						<th>prize</th>
				                                       
						<th>total</th>
						
						
					</tr>
				</thead>
				<c:forEach items="${cartitm}" var="product">
				<form action="updateqty" method="get">
				<tr >
			    <td><img src="resources/images/${product.pid}.jpg" height="50px" 
                  width="50px"></td>
				<td>${product.name}</td>
				   <td><input type="text" name="qty" value="${product.qty}" />
				   <input type="hidden" name="pid" value="${product.pid}"/>&nbsp;&nbsp;&nbsp; <input type="submit" value="update"></td>
				   <td>${product.price}</td>
				   <td>${product.qty*product.price}</td>
					
                    <td><a href="Removecart?pid=${product.pid}">Remove</a></td>
                     
                    </tr>
				</form>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>


							<td>GrandTotal:${sessionScope.grandtotal}</td>
						</tr>
	</table>
	
	</sf:form>
				
				

</c:otherwise>

</c:choose>
</div>

<div class="container">
	<a href="DisplayProduct"><h1>Continue Shopping</h1></a>
    <a href="HeyOrderConfirmation"><h1>Place Your Order</h1></a>		


                  </div>
                 