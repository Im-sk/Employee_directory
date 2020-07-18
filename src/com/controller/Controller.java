package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.DAO.EmployeeDAOImpl;
import com.entity.Employee;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
//	create a reference variable for employee DAO
	EmployeeDAO employeeDAO = null;	
	
	
//	create a constructor and initalize the DAO implementation as the EmployeeDAO is an Interface
	public Controller() {
//		super();

		employeeDAO = new EmployeeDAOImpl();		
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if( action == null){
			action = "LIST";
		}
		
		
		switch(action){
		
		case "LIST":
			listEmployee(request, response);
			break;
		case "EDIT":
			getSingleEmployee(request,response);
			break;
		case "DELETE":
			deleteEmployee(request,response);
			
			break;
			
		default:
			listEmployee(request, response);
			break;
			
				
		
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		doGet(request, response);
		String id = request.getParameter("id");
		String name = request.getParameter("firstname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("Department");
		
//		System.out.println(name);
//		System.out.println(dob);
//		System.out.println(designation);
		
		
		Employee e = new Employee();
		
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		
		if(id.isEmpty() || id == null){
			// save operation

			if(employeeDAO.save(e)){			
				request.setAttribute("message", "Saved Successfully ! ");			
			}		
		}else{
			//Update operation
			e.setId(Integer.parseInt(id));

			if(employeeDAO.update(e)){		
				request.setAttribute("message", "Updated Successfully ! ");
			}
			
		}
		
		
//		request.getRequestDispatcher("/views/employee-add.jsp").forward(request, response);
		
		listEmployee(request, response);
		
	}
	
	public void listEmployee(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
//		call DAO get method to get list of employees
		
		List<Employee> list = employeeDAO.get();
		
		
//		 Add  employees to request object
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/employee-list.jsp").forward(request, response);
		
		
	}
	
	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String id = request.getParameter("id");
//		System.out.println("id ="+ id);
		Employee employee = employeeDAO.get(Integer.parseInt(id));
		
//		System.out.println("WELCOME my name is : "+ employee.getName()+ " "+employee.getDepartment()  );
//		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/views/employee-add.jsp").forward(request, response);	
		
	}
	
	
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String id = request.getParameter("id");
		
		if(employeeDAO.delete(Integer.parseInt(id))){
			
			request.setAttribute("message", "Record Deleted Successfully" );
//			listEmployee(request, response);
			
		}
	    
		listEmployee(request, response);
		
	 }
	
	
	
	
	
	
	
	
}
