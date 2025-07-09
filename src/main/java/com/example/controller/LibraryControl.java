package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Library;
import com.example.repository.LibraryRepo;
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class LibraryControl {
	@Autowired
	LibraryRepo Lrepo;

	public LibraryRepo getLrepo() {
		return Lrepo;
	}

	public void setLrepo(LibraryRepo lrepo) {
		Lrepo = lrepo;
	}
	//insert
	@PostMapping("/add")
	public String add(@RequestBody Library library) throws ClassNotFoundException, SQLException
	{
		return Lrepo.add(library);
		
	}
	//select
	@GetMapping("/show")
	public List<Library> show() throws ClassNotFoundException, SQLException
	{
		return Lrepo.show();
		
	}
	//getAllItems
	@GetMapping("/getAllItems")
	public List<Library> getAllItems() throws ClassNotFoundException, SQLException
	{
		return Lrepo.getAllItems();
	}
	//update
	@PutMapping("/updated")
	public String updated(@RequestBody Library library) throws ClassNotFoundException, SQLException
	{
		return Lrepo.updated(library);
		
	}
	//delete
	@DeleteMapping("deleted/{bid}")
	public String deleted(@PathVariable String bid) throws ClassNotFoundException, SQLException
	{
		return Lrepo.deleted(bid);
		
	}
	

}
