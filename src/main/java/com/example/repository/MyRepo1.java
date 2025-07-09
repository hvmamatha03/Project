package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pojo.Book;

@Repository
public class MyRepo1 {

	public String print(Book book) throws SQLException, ClassNotFoundException 
	{

			String url="jdbc:mysql://localhost:3306/ch20";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			String q="INSERT INTO BOOK VALUES(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1, book.getId());
			pst.setString(2,book.getName());
			pst.setString(3,book.getAuthor());
			pst.setInt(4, book.getPrice());
			pst.setInt(5, book.getYear());
			int rows=pst.executeUpdate();
			con.close();
			return rows+" ROWS INSERTED SUCCESSFULLY";
	}
	public List<Book> print1(Book book) throws ClassNotFoundException, SQLException
	{
		Book b1=new Book();
		List<Book> list=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="INSERT INTO BOOK VALUES(?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery("SELECT * FROM BOOK");
		while(rs.next())
		{
			b1.setId(rs.getInt(1));
			b1.setName(rs.getString(2));
			b1.setAuthor(rs.getString(3));
			b1.setPrice(rs.getInt(4));
			b1.setYear(rs.getInt(5));
			list.add(b1);
		}
		con.close();
		return list;	
	}
	public String print2(Book book) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="UPDATE BOOK SET ID=? WHERE name=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, book.getId());
		pst.setString(2, book.getName());
		int rows=pst.executeUpdate();
		con.close();
		return rows+" ROWS UPDATED SUCCESSFULLY";
	}
	public String print3(int id) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="DELETE FROM BOOK  WHERE id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,id);
		int rows=pst.executeUpdate();
		con.close();
		return rows+" ROWS DELETED SUCCESSFULLY";
	}
		
}
