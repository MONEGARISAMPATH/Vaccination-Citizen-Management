package com.project2.CitizenService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.CitizenService.Entity.Citizen;


@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Integer>{

	 Citizen findByVacitinationCenterId(Integer id);
	
	
}
