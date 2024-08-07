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

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;

@Service
public class VaccinationCenterService {
	@Autowired
	CitizenCilent citizenCilent;
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	int attempt=0;

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
	//By using CircuitBreaker
	/*
	 * @CircuitBreaker(name = "CitizenBreaker",
	 * fallbackMethod="CitizenBreakerFallBack")
	 */
	//Retry Method
	/*
	 * @Retry(name = "CitizenBreaker", fallbackMethod="CitizenBreakerFallBack")
	 */
	@RateLimiter(name = "CitizenBreaker", 
			fallbackMethod="CitizenBreakerFallBack")
	
	public ResponseEntity<VaccinationDto> getAllDataById(Integer id) {
		System.out.println("Attempt: "+ attempt++);
		VaccinationDto dto = new VaccinationDto();
		VaccinationCenter vaccination = vaccinationRepo.findAll().get(id);
		dto.setCenter(vaccination);
		Citizen citizen = citizenCilent.getCitizen(id);
		dto.setCitizen(citizen);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	public ResponseEntity<VaccinationCenter> CitizenBreakerFallBack(Integer id,Exception e){
		VaccinationCenter vaccinationDetails=	vaccinationRepo.findAll().get(id);
		return  new ResponseEntity<>( vaccinationDetails,HttpStatus.OK);
		
	}
	public void deleteById(int id) {
		vaccinationRepo.deleteById(id);

	}

}
