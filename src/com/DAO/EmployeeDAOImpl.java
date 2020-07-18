package com.DAO;

import java.sql.*;
import java.util.*;
import com.entity.Employee;
//import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import com.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	Connection connection = null;
	ResultSet resultset = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	
	@Override
	public List<Employee> get(){
		
		List<Employee> list = null;
		Employee employee = null;
		
		try{
			
			list = new ArrayList<Employee>();
			
//				Create a sql query
			
			String sql = "SELECT * from tbl_employee";
			
//				get the database connection	
		
			connection = DBConnectionUtil.openConnection();
			
//				create statement
			
			statement = connection.createStatement();
			
//				Execute sql query
			
			resultset = statement.executeQuery(sql);
			
//				Process the result set
			
			while(resultset.next()){
				employee = new Employee();
				
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setDepartment(resultset.getString("department"));
				employee.setDob(resultset.getString("dob"));
				
//				Add employee to the list		
				list.add(employee);
			}				
		}catch(Exception e){
			e.printStackTrace();
		}		
//		return the list		
		
		return list;
	}


	@Override
	public boolean save(Employee e){
		
		boolean flag = false;
		try{
//			connection.setAutoCommit(false);
			String sql = "INSERT INTO tbl_employee(name, dob, department) VALUES('"+e.getName()+"' , '"+e.getDob()+"' , '"+e.getDepartment()+"'  )";
			connection = DBConnectionUtil.openConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
		    
//			if(preparedStatement.execute()){
//				connection.commit();
//			}
			
			flag = true;
			
		}catch(SQLException ex){
//			try {
//			
//				   
//				   connection.rollback();   
//			   
//			   
//				
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			ex.printStackTrace();
			
		}
//		finally{
//			try {
//				connection.close();
//				statement.close();
//				resultset.close();
//			} catch (SQLException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			
//			
//		}	
		return flag;
	}


	@Override
	public Employee get(int id) {
		
		Employee employee= null;
		
		try{
			employee = new Employee();
			
			String sql = "SELECT * FROM tbl_employee WHERE id = "+ id;
			connection = DBConnectionUtil.openConnection();
			statement =  connection.createStatement();
			resultset = statement.executeQuery(sql);
			
			
			while(resultset.next()){
				
				
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setDepartment(resultset.getString("department"));
				employee.setDob(resultset.getString("dob"));
				
			}				
		}catch(SQLException ex){
			
			ex.printStackTrace();
		} 
		
		         
//		System.out.println("WELCOME my name is : "+ employee.getName()+ " "+employee.getId()  );
		
		return employee;
		
	}


	@Override
	public boolean update(Employee e) {
		
		boolean flag = false;
		
		try{
			
			
			String sql = "UPDATE tbl_employee set name = '" +e.getName()+ "', dob = '" +e.getDob()+ "', department = '" +e.getDepartment()+ "' where id = "+e.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			flag = true;
			
		}catch(Exception e1){
			
			e1.printStackTrace();
		}
				
		return flag;
	}


	@Override
	public boolean delete(int id) {
		// 
		boolean flag= false;
		
		try{
			
			String sql = "DELETE from tbl_employee WHERE id = " +id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			flag = true;
			
			
		}catch(SQLException ex){
			
			ex.printStackTrace();
			
		}
		
		
		return flag;
	}

	
	
	
	
}
