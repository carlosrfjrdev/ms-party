package com.thinkhack.geopolis.msparty.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkhack.geopolis.msparty.model.PartyModel;
import com.thinkhack.geopolis.msparty.repository.PartyRepository;

@Service
public class PartyService {
	
	final PartyRepository partyRepository;

	public PartyService(PartyRepository partyRepository) {
		this.partyRepository = partyRepository;
	}
	
	@Transactional
	public PartyModel save(PartyModel partyModel) {
		return partyRepository.save(partyModel);
	}

	
	public boolean existsByPartyName(String playerName) {
        return partyRepository.existsByPartyName(playerName);
    }

	public Page<PartyModel> findAll(Pageable pageable) {
		return partyRepository.findAll(pageable);
	}

	public Optional<PartyModel> findById(UUID id) {
		return partyRepository.findById(id);
	}

	@Transactional
	public void delete(PartyModel partyModel) {
		partyRepository.delete(partyModel);
	}

}
