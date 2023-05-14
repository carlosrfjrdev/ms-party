package com.thinkhack.geopolis.msparty.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PARTY_MEMBER")
public class PartyMemberModel implements Serializable {

	
	private static final long serialVersionUID = -1431167373755211216L;
	
	@Id
	@Column(nullable = false, unique = true)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID playerID;
	
	@ManyToMany(mappedBy = "members")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID partyID;
	
	
	private boolean owner;


	private boolean secretary;
	
	

	public UUID getPartyID() {
		return partyID;
	}

	public void setPartyID(UUID partyID) {
		this.partyID = partyID;
	}

	public UUID getPlayerID() {
		return playerID;
	}

	public void setPlayerID(UUID playerID) {
		this.playerID = playerID;
	}

	public boolean isSecretary() {
		return secretary;
	}

	public void setSecretary(boolean secretary) {
		this.secretary = secretary;
	}
	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

}
