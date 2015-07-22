<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='dataBaseHR.Departments' %>
<%@ page import='dataBaseHR.Employees' %>
<%@ page import='java.util.List' %>
<%@ page import='java.util.Iterator' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Empleados</title>
<link rel="stylesheet" href="myCSS.css">
</head>
<body>
<%
List<Employees> listaEmpleados = (List<Employees>)request.getAttribute("listaEmpleados");
Iterator<Employees> it = listaEmpleados.iterator();
if (it.hasNext()){ %>
<h3>Lista de Empleados del Departamento <%= request.getParameter("dept") %></h3>
<form action="RecuperarEmpleadosPorDepts">
<table>
<thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
        </tr>
</thead>
<%
while (it.hasNext())
{
	Employees e = it.next();
	%>
	<tbody>
	<tr>
	<td><%=e.getFirstName()%></td>
	<td><%=e.getLastName() %></td>
	</tr>
	</tbody>
	<%
}
}
else {
	%>
	<p>
	<%=("Ningun empleado pertenece al departamento " + request.getParameter("dept"))%>
	</p>
<%
}
%>
</table>
</form>
</body>
</html>