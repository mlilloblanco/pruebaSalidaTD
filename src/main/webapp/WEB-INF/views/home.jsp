<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Talento Digital</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Prueba Salida Talento Digital</h1>

	<div class="container">
		<hr>
		<h4 class="display-6">Busqueda de vendedores</h4>
		<hr>
		<form:form action="${pageContext.request.contextPath}/buscar"
			method="post">
			<div class="row">
				<div class="col-3">Oficina:</div>
				<div class="col-7">
					<select id="OfficeCode" name="officeCode"
						class="form-control form-control">
						<option>Seleccione Oficina</option>
						<c:forEach items="${model.listaOficinas}" var="ofi">
							<option value="${ofi.getOfficeCode()}">${ofi.getCity()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-3">Sales Manager:</div>
				<div class="col-7">
					<select id="salesManager" name="employeeNumber"
						class="form-control form-control">
						<option>Seleccione SM</option>
						<c:forEach items="${model.listaSM}" var="emp">
							<option value="${emp.getManager().getEmployeeNumber()}">${emp.getFirstName() }
								${emp.getLastName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-1">
					<input class="btn btn-success" type="submit" value="Buscar">
				</div>
			</div>
			<br>
		</form:form>
	</div>
	<c:if test="${not empty model.empleados}">
		<div class="container">
			<hr>
			<h4 class="display-6">Vendedores</h4>
			<table class="table">
				<thead class="thead_dark">
					<tr>
						<th>Num Empleado</th>
						<th>Nombre</th>
						<th>Mail</th>
						<th>Oficina</th>
						<th>Manager</th>
						<th>Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${model.empleados}" var="emp">
						<tr>
							<td><c:out value="${emp.getEmployeeNumber()}" /></td>
							<td><c:out value="${emp.getFirstName()} " /> <c:out
									value="${emp.getLastName()}" /></td>
							<td><c:out value="${emp.getEmail()}" /></td>
							<td><c:out value="${emp.getOffice().getCity()}" /></td>
							<td><c:out value="${emp.getManager().getFirstName() }" /> <c:out
									value="${emp.getManager().getLastName()}" /></td>
							<td><a class="btn btn-primary" href="#">Ver</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>