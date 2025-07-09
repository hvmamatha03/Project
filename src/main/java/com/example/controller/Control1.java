package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Book;
import com.example.repository.MyRepo1;

@RestController
public class Control1 {

	@Autowired
	MyRepo1 repo1;

	public MyRepo1 getRepo1() {
		return repo1;
	}

	public void setRepo1(MyRepo1 repo1) {
		this.repo1 = repo1;
	}
	
	@PostMapping("/print")
	public String print(@RequestBody Book book) throws ClassNotFoundException, SQLException
	{
		return repo1.print(book);
		
	}
	@GetMapping("/print1")
	public List<Book> print1(@RequestBody Book book) throws ClassNotFoundException, SQLException
	{
		return repo1.print1(book);
		
	}
	@PutMapping("/print2")
	public String print2(@RequestBody Book book) throws ClassNotFoundException, SQLException
	{
		return repo1.print2(book);
		
	}
	@DeleteMapping("/print3/{id}")
	public String print3(@PathVariable int id) throws ClassNotFoundException, SQLException
	{
		return repo1.print3(id);
		
	}

}
