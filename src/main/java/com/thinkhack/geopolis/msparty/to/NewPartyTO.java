package com.thinkhack.geopolis.msparty.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewPartyTO {
	
	@NotBlank
	private String partyName;
	
	@NotBlank
	private String partyAbbreviation;
	
	@NotBlank
	private String ownerPlayerID;

	@Size(max = 1000)
	private String description;
	
	private long moneySalary;

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyAbbreviation() {
		return partyAbbreviation;
	}

	public void setPartyAbbreviation(String partyAbbreviation) {
		this.partyAbbreviation = partyAbbreviation;
	}

	public String getOwnerPlayerID() {
		return ownerPlayerID;
	}

	public void setOwnerPlayerID(String ownerPlayerID) {
		this.ownerPlayerID = ownerPlayerID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMoneySalary() {
		return moneySalary;
	}

	public void setMoneySalary(long moneySalary) {
		this.moneySalary = moneySalary;
	}
}
