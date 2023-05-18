<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h1>Dados do Funcionário</h1>
<form action="<%=request.getContextPath() %>/dadosEmpregado" method=get>
<table style="width=80%">
	<tr>
		<td>Nome: </td>
		<td>
			<h3><%= request.getAttribute("name") %></h3>
		</td>
		
		<td>Sobrenome: </td>
		<td>
			<h3><%= request.getAttribute("lastName") %> </h3>
		</td>
		
		<td>Endereço: </td>
		<td>
			<h3><%= request.getAttribute("address") %> </h3>
		</td>
		
		<td>Contato: </td>
		<td>
			<h3><%=request.getAttribute("contact") %> </h3>
		</td>
	</tr>

</table>
</form>
</body>
</html>