
package com.project2.CitizenService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private int vacitinationCenterId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVacitinationCenterId() {
		return vacitinationCenterId;
	}

	public void setVacitinationCenterId(int vacitinationCenterId) {
		this.vacitinationCenterId = vacitinationCenterId;
	}

}
