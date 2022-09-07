<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Producto</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Añadir un Producto
</h1>

<c:url var="addAction" value="/product/add" ></c:url>

<form:form action="${addAction}" commandName="product">
<table>
	<c:if test="${!empty product.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Descripción"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty product.name}">
				<input type="submit"
					value="<spring:message text="Editar producto"/>" />
			</c:if>
			<c:if test="${empty product.name}">
				<input type="submit"
					value="<spring:message text="Añadir producto"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de productos</h3>
<c:if test="${!empty listProducts}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Descripción</th>
		<th width="60">Editar</th>
		<th width="60">Borrar</th>
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.description}</td>
			<td><a href="<c:url value='/edit/${product.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/remove/${product.id}' />" >Borrar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
