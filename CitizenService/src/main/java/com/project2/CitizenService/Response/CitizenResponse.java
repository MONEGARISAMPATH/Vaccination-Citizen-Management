package com.project2.CitizenService.Response;

import com.project2.CitizenService.Entity.Citizen;

public class CitizenResponse {
	
	    private Citizen citizen;
	    private String serverPort;

	    public CitizenResponse(Citizen citizen, String serverPort) {
	        this.citizen = citizen;
	        this.serverPort = serverPort;
	    }

		public Citizen getCitizen() {
			return citizen;
		}

		public void setCitizen(Citizen citizen) {
			this.citizen = citizen;
		}

		public String getServerPort() {
			return serverPort;
		}

		public void setServerPort(String serverPort) {
			this.serverPort = serverPort;
		}

	    
	}