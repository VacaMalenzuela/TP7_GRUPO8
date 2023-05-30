<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar seguro</title>
</head>
<body>


	 <a href="Inicio.jsp">Inicio</a>
     <a href="AgregarSeguro.jsp">Agregar seguro</a>
     <a href="ListarSeguro.jsp">Listar seguro</a>

<section>
<h1>Agregar Seguro</h1>

<form method="get" action="servletSeguro">
Id Seguro: <br><br>
Decripcion: <input type="text" name="txtDescripcion"> <br><br>
Tipo de seguro: <select name="tipoSeguro">
	<option value="1">Seguro de casas</option>
	<option value="2">Seguro de vida</option>
	<option value="3">Seguro de motos</option>
</select> <br><br>
Costo contratacón: <input type="text" name="txtCostoContratacion"> <br><br>
Costo maximo asegurado: <input type="text" name="txtCostoMaximoAsegurado"> <br><br><br><br>
<input type="submit" name="btnAceptar" value="Aceptar">
</form>
</section>

<% int filas=0;
if(request.getAttribute("cantFilas") != null){
	  filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
}
%>


<% if(request.getAttribute("cantFilas") != null && filas == 0){ %>
	Los campos ingresados no son correctos.
	
<%}%>
<%if(filas==1){ %>
	Usuario agregado correctamente.
<%}%>




</body>

</body>
</html>