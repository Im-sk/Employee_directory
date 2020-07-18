

<html>
    
    <head>
    		
    		<title>Welcome to DataBase</title>
    			
    		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    		
      		
    </head>
   
	<body>	
		
			
			<%
			   String email = (String) session.getAttribute("email");
			
			   if(email != null){
				   
				   response.sendRedirect("Controller?action=LIST");
			   }
			   
			   
			   
				String st = request.getParameter("status");
				/* System.out.print("st="+st); */
			    	
			    	if(st != null){
				    		if(st.equals("wrong")){
								out.print("Login Credential Not Correct !!");
					    	}else if(st.equals("error")){
							 	out.print("Bad GateWay !!");								    
					    	} 
				    }else{
				    			out.print("Some Data Required !!");
				    }
			
			%>
			
			
						
		
			
		<div class = "container">
		
			<form action="loginprocess" method="post">
				<div  class ="card"  >						    	
					
				<div class= "card-header " >
					Enter Login Credentials 				
				</div>	
				
			    	<div class = "card-body">
				 	
				 		<div class = "form-group">
				 		<input type = "text" placeholder="Email_id"  name = "email"  class="form-control" required ><br/>
				 		</div>
					
				 	
				 		<div class = "form-group">
				 		<input type = "password" placeholder="Password" name = "password" class="form-control" required><br/>
				 		</div>
				 	
					</div>
						
		
					<div class = "class-footer ">
						 <input type = "submit" value = "login" class="btn btn-primary"><br/>
					</div>
				</div>												
							
			</form>
		
		</div>
	</body>
</html>