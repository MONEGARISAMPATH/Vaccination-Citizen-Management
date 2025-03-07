package com.project2.VaccinationCenter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.project2.VaccinationCenter.Dto.VaccinationDto;
import com.project2.VaccinationCenter.Entity.VaccinationCenter;

import com.project2.VaccinationCenter.Service.VaccinationCenterService;

@RestController
@RequestMapping("/VaccinationCenter")
public class VaccinationCenterContoller {
	@Autowired
	Environment environment;

	@GetMapping("/ServerPort/check")
	public String stauts() {
		return "VaccinationService" + " " + environment.getProperty("local.server.port");

	}

	@Autowired
	VaccinationCenterService vaccinationservice;

	@PostMapping("/addVaccinationDetails")
	public ResponseEntity<VaccinationCenter> addVaccinationCenterDetails(@RequestBody VaccinationCenter vaccination) {
		return vaccinationservice.addVaccinationCenterDetails(vaccination);

	}

	@GetMapping("/getDataById/{id}")
	public ResponseEntity<VaccinationDto> getAllDataById(@PathVariable int id) {
		return vaccinationservice.getAllDataById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		vaccinationservice.deleteById(id);
		return "Successfully Deleted";
	}

}
