package com.DAO;

import com.entity.Login;
//import com.mysql.cj.protocol.Resultset;
import com.util.DBConnectionUtil;
import java.sql.*;
//import java.util.*;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public String authenticate(Login login) {
		
		String sql = "SELECT * from tbl_login where email = ? and password = ? ";
		
		try{
			
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, login.getEmail());
			ps.setString(2, login.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return "right";				
			}else{
				return "wrong";
				}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "error";
	}
	
	

}
