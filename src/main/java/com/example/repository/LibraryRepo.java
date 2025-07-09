package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pojo.Library;
@Repository
public class LibraryRepo 
{
	//insert data
	public String add(Library library) throws SQLException, ClassNotFoundException 
	{
			String url="jdbc:mysql://localhost:3306/ch20";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			String q="INSERT INTO LIBRARY VALUES(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, library.getBid());
			pst.setString(2,library.getBname());
			pst.setString(3,library.getBauthor());
			pst.setString(4, library.getBprice());
			pst.setString(5, library.getByear());
			int rows=pst.executeUpdate();
			con.close();
			return rows+" ROWS INSERTED SUCCESSFULLY";
	}
	//select data
	public List<Library> show()throws SQLException, ClassNotFoundException 
	{
		List<Library> list=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="SELECT * FROM Library";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Library b1=new Library();
			b1.setBid(rs.getString(1));
			b1.setBname(rs.getString(2));
			b1.setBauthor(rs.getString(3));
			b1.setBprice(rs.getString(4));
			b1.setByear(rs.getString(5));
			list.add(b1);
		}
		con.close();
		return list;
	}
	//update
	public String updated(Library library) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="UPDATE LIBRARY SET BID=? WHERE bname=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, library.getBid());
		pst.setString(2, library.getBname());
		int rows=pst.executeUpdate();
		con.close();
		return rows+" ROWS UPDATED SUCCESSFULLY";
	}
	//delete
	public String deleted(String bid) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="DELETE FROM LIBRARY WHERE bid=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,bid);
		int rows=pst.executeUpdate();
		con.close();
		return rows+" ROWS DELETED SUCCESSFULLY";
	}
	//getAllitems
	public List<Library> getAllItems()throws SQLException, ClassNotFoundException 
	{
		List<Library> list=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/ch20";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		String q="SELECT * FROM Library";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			Library b1=new Library();
			b1.setBid(rs.getString(1));
			b1.setBname(rs.getString(2));
			b1.setBauthor(rs.getString(3));
			b1.setBprice(rs.getString(4));
			b1.setByear(rs.getString(5));
			list.add(b1);
			return list;
		}
		con.close();
		return null;
	}

}
