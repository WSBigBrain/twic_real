package com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "longitude", "latitude" })
public class Coordonnees {
	
	public Coordonnees() {	
		super();
	}
	
	public Coordonnees(String longitude, String latitude) {
		super();
		this.setLongitude(longitude);
		this.setLatitude(latitude);
	}
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	public String getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}