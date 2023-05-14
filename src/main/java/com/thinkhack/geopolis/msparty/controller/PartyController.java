package com.thinkhack.geopolis.msparty.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkhack.geopolis.msparty.enums.MessageType;
import com.thinkhack.geopolis.msparty.exception.WrongEventException;
import com.thinkhack.geopolis.msparty.exception.WrongEventValueException;
import com.thinkhack.geopolis.msparty.model.PartyModel;
import com.thinkhack.geopolis.msparty.service.EventService;
import com.thinkhack.geopolis.msparty.service.PartyService;
import com.thinkhack.geopolis.msparty.to.EventTO;
import com.thinkhack.geopolis.msparty.to.MessageTO;
import com.thinkhack.geopolis.msparty.to.NewPartyTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/party")
public class PartyController {
	final PartyService partyService;

	public PartyController(PartyService partyService) {
		this.partyService = partyService;
	}

//	private final static long INITIAL_EXPERIENCE = 500L;
//	private final static int INITIAL_SKILL = 50; 
//	private final static int INITIAL_ENERGY = 50; 
//	private final static long INITIAL_MONEY = 10000000L; 
//	private final static long INITIAL_GOLD = 1000L; 
	
	@PostMapping
	public ResponseEntity<Object> saveParty(@RequestBody @Valid NewPartyTO newPartyTO){
		boolean newParty = this.isNewParty(newPartyTO);
		if(newParty) {
			var partyModel = this.getNewParty(newPartyTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(partyService.save(partyModel));
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageTO(MessageType.WARNING,"saveParty", "Conflict: Party Name is already in use!"));
		}
	}




	@GetMapping
	public ResponseEntity<Page<PartyModel>> getAllPartys(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(partyService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParty(@PathVariable(value = "id") UUID id){
		Optional<PartyModel> partyModelOptional = partyService.findById(id);
		if (partyModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(partyModelOptional.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageTO(MessageType.WARNING,"getOneParty", "Party not found."));
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParty(@PathVariable(value = "id") UUID id){

		Optional<PartyModel> partyModelOptional = partyService.findById(id);

		if (partyModelOptional.isPresent()) {
			partyService.delete(partyModelOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body(new MessageTO(MessageType.INFO,"deleteParty", "Party deleted successfully."));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageTO(MessageType.WARNING,"deleteParty", "Party not found."));
		}

	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Object> updatePartyByEvent(@PathVariable(value = "id") UUID id,
//			@RequestBody @Valid EventTO event){
//
//		Optional<PartyModel> partyModelOptional = partyService.findById(id);
//		EventService evt = new EventService();
//
//		if (partyModelOptional.isPresent()) {
//			PartyModel partyModel;
//			try {
//				partyModel = evt.getPartyUpdateByEvent(partyModelOptional.get(),event);
//
//				evt.partyEventListener(event,partyModelOptional.get(),partyModel);
//				return ResponseEntity.status(HttpStatus.OK).body(partyService.save(partyModel));
//			} catch (WrongEventException e) {
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageTO(MessageType.ERROR,"updatePartyByEvent", "Incorrect Party event."));
//			} catch (WrongEventValueException e) {
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageTO(MessageType.ERROR,"updatePartyByEvent", "Incorrect value for event."));
//			}
//
//
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageTO(MessageType.WARNING,"updatePartyByEvent", "Party not found."));
//		}
//
//
//
//	}

	//METODOS PRIVADOS



	private boolean isNewParty(NewPartyTO newPartyTO) {

		return !partyService.existsByPartyName(newPartyTO.getPartyName());
	}


	private PartyModel getNewParty(NewPartyTO partyDTO) {
		PartyModel partyModel = new PartyModel();
		BeanUtils.copyProperties(partyDTO, partyModel);
		

		
		return partyModel;
	}


	



}
