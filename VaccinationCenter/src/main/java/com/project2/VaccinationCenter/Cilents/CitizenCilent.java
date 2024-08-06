package com.project2.VaccinationCenter.Cilents;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project2.CitizenService.Entity.Citizen;

@FeignClient(name = "CITIZENSERVICE")
public interface CitizenCilent {
	@GetMapping("/Citizen/{id}")
	Citizen getCitizen(@PathVariable Integer id);
}
