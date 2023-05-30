<%@page import="java.util.ArrayList" %>
<%@page import="dominio.Seguro" %>
<%@page import="dominio.seguroDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar seguro</</title>
</head>
<body>

	 <a href="Inicio.jsp">Inicio</a>
     <a href="AgregarSeguro.jsp">Agregar seguro</a>
     <a href="ListarSeguro.jsp">Listar seguro</a>
     
     <h1>"Tipo de seguros de la base de datos"</h1>
     <form method="post" action="servletSeguro">
          Busqueda por tipo de Seguros: <select name="tipoSeguro">
				<option value="1">Seguro de casas</option>
				<option value="2">Seguro de vida</option>
				<option value="3">Seguro de motos</option>
</select> <input type="submit" name="btnFiltrar" value="Filtrar">
     </form>
     
          <% 
          seguroDao traeTodos = new seguroDao();
          
     ArrayList<Seguro> lstSeguro=traeTodos.obtenerSeguros();
     if(request.getAttribute("listaFiltrada") != null){
    	 lstSeguro = (ArrayList<Seguro>)request.getAttribute("listaFiltrada");
    }%>
     <table border="1">
     <tr>
     	<th>ID</th> <th>DESCRIPCION</th> <th>TIPO</th> <th>COSTO CONT.</th> <th>COSTO MAX. ASEG.</th>
     </tr>
     <%
     if (lstSeguro!=null) 
	 for(Seguro item : lstSeguro) {%>
     <tr>
     	<td> <%=item.getId()%></td>   <td><%=item.getDescripcion()%> </td>  <td> <%=item.getIdTipo().getDescripcion()%></td>   <td> <%=item.getCostoContratacion()%></td>  <td> <%=item.getCostoAsegurado()%></td>
     </tr>
     <%} %>
     </table>
     

     

     
</body>
</html>