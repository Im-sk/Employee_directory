package com.DAO;

// This is Interface

import com.entity.*;
import java.util.*;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	boolean save(Employee e);
	
	Employee get(int id);
	
	boolean update(Employee e);
	
	boolean delete(int id);

}
