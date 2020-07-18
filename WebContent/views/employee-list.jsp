<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	
	<title>Employee List</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>

</head>
<body>
       
       <%
            String email = (String) session.getAttribute("email");
       		if(email == null){
       			response.sendRedirect("index.jsp");
       		}
         
       %>




		<div class="container">
		  <div class = "float-right">
      
    		  <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
     
          </div>
     	
		  <p> ${ message } </p>  
		<button class = "btn btn-primary" onclick="window.location.href= 'views/employee-add.jsp'"> Add Employee</button>
		<hr/>
			<table border="1"  class ="table table-striped table-bordered table-hover" id = "datatable">
		 		
		 		<thead>
		 			<tr class = "thead-dark" >
		 				<th> Name </th>
		 				<th> Department </th>
		 				<th> Date of Birth </th>
		 				<th> Actions</th>		 				
		 			</tr>
		 		</thead>
		 		
		 	
		 		<tbody>
		 					<c:forEach  items = "${list}" var = "employee" >
		 		     <tr>
		 		         <td> ${ employee.name } </td>
		 		         <td> ${ employee.department  } </td>
		 		         <td> ${ employee.dob } </td>
		 		         <td>
		 		          	 <a href ="${pageContext.request.contextPath}/Controller?action=EDIT&id=${employee.id}" >Edit</a>
		 		          	 |
		 		          	 <a href ="${pageContext.request.contextPath}/Controller?action=DELETE&id=${employee.id}" >Delete</a>
		 		         </td>
		 		     </tr>		
		 		
		 		</c:forEach>
		 		
		 		</tbody>
		 
		</table>
		
		
		</div>

<script src = "https://unpkg.com/jquery@3.3.1/dist/jquery.min.js "></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>

<script>
 		$(document).ready(function(){
 			
 			$("#datatable").DataTable();
 		})
 		
</script>


</body>
</html>