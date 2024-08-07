package com.project2.CitizenService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project2.CitizenService.Entity.Citizen;
import com.project2.CitizenService.Repository.CitizenRepository;

//import java.util.List;

@Service

public class Service1 {
	@Autowired
	CitizenRepository citizenrepo;

	public ResponseEntity<Citizen> getById(Integer id) {
		// case:1,we can create own method in Repository or case:2

		try {
			Citizen citizen = citizenrepo.findByVacitinationCenterId(id);
			return new ResponseEntity<Citizen>(citizen, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// case 2:jpaRepository have default methods so we can use that methods
	/*
	 * try { Citizen citizenList= citizenrepo.findById(id).get(); return new
	 * ResponseEntity<>(citizenList,HttpStatus.ACCEPTED); }catch(Exception e) {
	 * e.printStackTrace(); } return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 */

	public ResponseEntity<Citizen> addCitizen(Citizen citizen) {
		try {
			Citizen listcitizen = citizenrepo.save(citizen);
			return new ResponseEntity<>(listcitizen, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	public void deleteById(int id) {
		citizenrepo.deleteById(id);

	}

}
