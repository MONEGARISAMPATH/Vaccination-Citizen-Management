package com.project2.VaccinationCenter.Dto;



import com.project2.CitizenService.Entity.Citizen;
import com.project2.VaccinationCenter.Entity.VaccinationCenter;

public class VaccinationDto {
	private VaccinationCenter center;
	private Citizen citizen;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}
