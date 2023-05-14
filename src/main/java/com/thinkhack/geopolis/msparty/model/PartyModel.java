package com.thinkhack.geopolis.msparty.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PARTY")
public class PartyModel implements Serializable {

	private static final long serialVersionUID = 9205403266143760510L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID id;
	
	
	@Column(nullable = false, unique = true, length = 30)
	private String partyName;
	@Column(nullable = false, unique = true, length = 10)
	private String partyAbbreviation;
	
	
	@Column(length = 1000)
	private String description;
	
	private long goldSalary;
	private long moneySalary;
	
	@ManyToMany
	@JoinTable(
	    name = "PARTY_MEMBER",
	    joinColumns = @JoinColumn(name = "partyID"),
	    inverseJoinColumns = @JoinColumn(name = "id")
	)
	private List<PartyMemberModel> members;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getGoldSalary() {
		return goldSalary;
	}

	public void setGoldSalary(long goldSalary) {
		this.goldSalary = goldSalary;
	}

	public long getMoneySalary() {
		return moneySalary;
	}

	public void setMoneySalary(long moneySalary) {
		this.moneySalary = moneySalary;
	}

	public List<PartyMemberModel> getMembers() {
		return members;
	}

	public void setMembers(List<PartyMemberModel> members) {
		this.members = members;
	}



	
	
	
	
}
