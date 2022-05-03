package com.example;

import java.util.List;

public interface EmployeeDAO {
	
	//Metodos de la interface

	List<Employee>  findAll();
	
	Employee finOne(Long id);
	
	boolean create(Employee employee);
	
	boolean update(Employee employee); 
	
	boolean delete(long id);

}
