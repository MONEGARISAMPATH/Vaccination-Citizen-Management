package com.project2.CitizenService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.CitizenService.Entity.Citizen;
import com.project2.CitizenService.Service.Service1;

@RestController
@RequestMapping("/Citizen")
public class CitizenController {
	@Autowired
	Environment environment;

	@GetMapping("/ServerPort/check")
	public String stauts() {
		return "CitizenService PortNum:" + " " + environment.getProperty("local.server.port");

	}

	@Autowired
	Service1 service;

	@GetMapping("{id}")
	public ResponseEntity<Citizen> getById(@PathVariable Integer id) {
		return service.getById(id);

	}

	@PostMapping("/addCitizen")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
		
		return service.addCitizen(citizen);
	}
	@DeleteMapping("/deleteCitizen/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "Successfully Deleted";
	}
}
