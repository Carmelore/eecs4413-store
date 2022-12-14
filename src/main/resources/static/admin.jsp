<div ng-controller="Stats">
	<h1>ADMIN</h1>
	<div>
		<h2>Sales for the month of {{month}}</h2>
		<table>
			<tr>
				<th>Product</th>
				<th>Quantity</th>
			</tr>
			<tr ng-repeat="sale in sales track by $index">
				<td>{{sale.product}}</td>
				<td>{{sale.quantity}}</td>
			</tr>
		</table>
	</div>
	<br />
	<div>
		<h2>Visits</h2>
	</div>
	<div>
		<h2>Discount Codes</h2>
		<form action="createDiscount">
			<label for="codeInput">New Code (15 chars)</label><input
				id="codeInput" placeholder="XXXXX" ng-model="newCode" /><br/>
			<input type="radio" id="total" name="totalOrPercent" value="total">
			<label for="total">total</label>
			<input type="radio" id="percent" name="totalOrPercent" value="percent">
			<label for="percent">percent</label>
			<button type="submit" ng-click="submit()">Add New Code</button>
		</form>
	</div>
	<!-- <form ng-controller="Stats" ng-submit="test()"> -->
	<!-- 	<input type="submit" value="test" /> -->
	<!-- </form> -->
</div>