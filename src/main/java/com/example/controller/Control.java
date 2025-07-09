package com.example.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Laptop;
import com.example.repository.MyRepo;

@RestController
public class Control {
	@Autowired
	MyRepo repo;

	public MyRepo getRepo() {
		return repo;
	}

	public void setRepo(MyRepo repo) {
		this.repo = repo;
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Laptop l) throws ClassNotFoundException, SQLException
	{
		return repo.save(l);
	}

}
