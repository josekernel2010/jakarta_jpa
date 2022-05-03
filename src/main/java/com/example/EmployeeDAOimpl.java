package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

	@Override
	public List<Employee> findAll() {
		
		List<Employee> lista = new ArrayList<>();
		//1. crear coneccion
		
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/jakarta_jdbc","root","1079");
		
					System.out.println();

				//2. Ejecutar sentencias
					
					Statement stc = cone.createStatement();
					
					String sql = "SELECT * FROM employeed" ;
				
				//3. Procesar resultados
					
					ResultSet rs = stc.executeQuery(sql);
					
					while(rs.next()) {
						
						long id = rs.getInt("id");
						String name = rs.getString("name");
						String nif = rs.getString("nif");
						Integer age = rs.getInt("age");
						
						System.out.println(id+" "+name+" "+nif+" "+age);
						System.out.println();
						
						Employee employee = new Employee(id,name, nif,age);
						
						lista.add(employee);
						
					}
					
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Error en la coneccion");
					System.out.println(e);
				}

		//devuelve el empleado
		return lista;
	}
	
	
	

	@Override
	public Employee finOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Employee employee) {
		
		boolean result = false;
		//1. crear coneccion
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/jakarta_jdbc","root","1079");
				
					System.out.println();

				//2. Ejecutar sentencias
					
					String sql = "INSERT INTO employeed (name , nif , age) VALUES (? , ? , ?)" ;
					
					PreparedStatement pst = cone.prepareStatement(sql);
					
					pst.setString(1, employee.getName());
					pst.setString(2, employee.getNif());
					pst.setInt(3, employee.getAge());
					
					pst.executeLargeUpdate();
					
					result = true;
				
					
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Error en la coneccion");
					System.out.println(e);
					
					
				}
				
				return result;
	}
	
	

	@Override
	public boolean update(Employee employee) {
		
		boolean result = false;
		//1. crear coneccion
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/jakarta_jdbc","root","1079");
	
			System.out.println();

		//2. Ejecutar sentencias
		//	UPDATE eli.publisher2 SET phone='111 111', name='OLD STORE' WHERE idpublisher=4;

			String sql = "UPDATE employeed SET name= ? , nif= ? , age= ?" ;
			
			PreparedStatement pst = cone.prepareStatement(sql);
			
			pst.setString(1, employee.getName());
			pst.setString(2, employee.getNif());
			pst.setInt(3, employee.getAge());
			
			pst.executeLargeUpdate();
			
			result = true;
		
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la coneccion");
			System.out.println(e);
			
			
		}
		
		return result;
	}
	

	@Override
	public boolean delete(long id) {
		
		boolean result = false;
		//1. crear coneccion
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/jakarta_jdbc","root","1079");
	
			System.out.println();

		//2. Ejecutar sentencias
		//	UPDATE eli.publisher2 SET phone='111 111', name='OLD STORE' WHERE idpublisher=4;

			String sql = "DELETE FROM employeed WHERE id= ?";
			
			PreparedStatement pst = cone.prepareStatement(sql);
			
			pst.setLong(1, id );
			
			pst.executeLargeUpdate();
			
			result = true;
		
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la coneccion");
			System.out.println(e);
			
			
		}
		
		return result;
	}
	
	

}
