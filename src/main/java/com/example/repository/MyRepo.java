package com.example.repository;

import java.sql.*;


import org.springframework.stereotype.Repository;

import com.example.pojo.Laptop;

@Repository
public class MyRepo {
public String save(Laptop l) throws SQLException, ClassNotFoundException 
{
		
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="INSERT INTO LAPTOP VALUES(?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, l.getNumber());
		pst.setString(2,l.getBrand());
		pst.setInt(3,l.getPrice());
		int rows=pst.executeUpdate();
		con.close();
		return rows+" ROWS INSERTED SUCCESSFULLY";
}
	

}
