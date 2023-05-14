package com.thinkhack.geopolis.msparty.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkhack.geopolis.msparty.model.PartyModel;

@Repository
public interface PartyRepository extends JpaRepository<PartyModel, UUID>{
	
	boolean existsByPartyName(String partyName);

}
