package com.project2.VaccinationCenter.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VaccinationCenter {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column
	private String centerName;
	@Column
	private String vaccinationCenterAddress;

	public VaccinationCenter() {
	}

	public VaccinationCenter(String centerName, String vaccinationCenterAddress) {
		this.centerName = centerName;
		this.vaccinationCenterAddress = vaccinationCenterAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getVaccinationCenterAddress() {
		return vaccinationCenterAddress;
	}

	public void setVaccinationCenterAddress(String vaccinationCenterAddress) {
		this.vaccinationCenterAddress = vaccinationCenterAddress;
	}

}
