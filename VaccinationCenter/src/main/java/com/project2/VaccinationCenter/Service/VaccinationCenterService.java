package com.project2.VaccinationCenter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project2.CitizenService.Entity.Citizen;
import com.project2.VaccinationCenter.Cilents.CitizenCilent;
import com.project2.VaccinationCenter.Dto.VaccinationDto;
import com.project2.VaccinationCenter.Entity.VaccinationCenter;
import com.project2.VaccinationCenter.Repository.VaccinationCenterRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class VaccinationCenterService {
	@Autowired
	CitizenCilent citizenCilent;
	/*
	 * @Autowired RestTemplate restTemplate;
	 */

	@Autowired
	VaccinationCenterRepository vaccinationRepo;

	

	public ResponseEntity<VaccinationCenter> addVaccinationCenterDetails(VaccinationCenter vaccination) {
		VaccinationCenter list = vaccinationRepo.save(vaccination);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// By using REST-TEMPLATE

	/*
	 * public ResponseEntity<JobDto> getAllDataById(Integer id){ //Details for
	 * vaccinationCenter JobDto res=new JobDto(); VaccinationCenter
	 * data=vaccinationRepo.findById(id).get(); res.setCenter(data);
	 * 
	 * //Details for citizen class to map we need RestTemplate
	 * listofCitizens=restTemplate.getForObject("http://localhost:8081/Citizen/"+id,
	 * Citizen.class); res.setCitizen(listofCitizens); return new
	 * ResponseEntity<>(res,HttpStatus.ACCEPTED); }
	 */
	@CircuitBreaker(name = "companyBreaker")
	public ResponseEntity<VaccinationDto> getAllDataById(Integer id) {
		VaccinationDto dto = new VaccinationDto();
		VaccinationCenter vaccination = vaccinationRepo.findAll().get(id);
		dto.setCenter(vaccination);
		Citizen citizen = citizenCilent.getCitizen(id);
		dto.setCitizen(citizen);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	public void deleteById(int id) {
		vaccinationRepo.deleteById(id);

	}

}
