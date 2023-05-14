package com.thinkhack.geopolis.msparty.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.thinkhack.geopolis.msparty.model.PartyModel;
import com.thinkhack.geopolis.msparty.to.EventTO;

@Service
public class EventService {

	public PartyModel getPartyUpdateByEvent(PartyModel partyModel, @Valid EventTO event) {
		// TODO Auto-generated method stub
		return null;
	}

	public void partyEventListener(@Valid EventTO event, PartyModel partyModelOld, PartyModel partyModelNew) {
		// TODO Auto-generated method stub
		
	}

}
