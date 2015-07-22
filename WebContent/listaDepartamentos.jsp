<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='dataBaseHR.Departments' %>
<%@ page import='java.util.List' %>
<%@ page import='java.util.Iterator' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Departamentos</title>
<link rel="stylesheet" href="myCSS.css">
</head>
<body>
<%! Iterator<Departments> it = null;
	Departments dept = null;
	List <Departments> listaDepts = null;
%>
      	<h3>Selecciona un departamento</h3>
      	<br>
      		<form action="RecuperarEmpleadosPorDepts">
				<select name="dept">
			<%	
				listaDepts = (List <Departments>)request.getAttribute("ld");
				it = listaDepts.iterator();
				while (it.hasNext()) {
					dept = it.next();
					%><option value="<%=dept.getDepartmentId()%>"><%=dept.getDepartmentName()%></option>
					<% } %>
				</select>
				<input type='submit' value='Buscar'>
			</form>
</body>
</html>