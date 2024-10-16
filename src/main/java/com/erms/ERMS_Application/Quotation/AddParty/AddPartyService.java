package com.erms.ERMS_Application.Quotation.AddParty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erms.ERMS_Application.Authentication.sales.Sales;
import com.erms.ERMS_Application.Authentication.sales.SalesRepository;

@Service
public class AddPartyService {
	
	
	@Autowired
	private AddPartyRepo addPartyRepo;
	
	@Autowired
	private SalesRepository salesRepo;

	public AddPartyEntity createParty(long salesId, AddPartyEntity addParty) {
		// TODO Auto-generated method stub
		
		Sales sale=salesRepo.findById(salesId).orElse(null);
		
		
		addParty.setSales(sale);
		return addPartyRepo.save(addParty);
	}
	
	public Optional<AddPartyEntity> getParty(long AdId){
		Optional<AddPartyEntity> add=addPartyRepo.findById(AdId);
		return add;
	}
	
	
	//////////////////GetAll AddParties////////////////////////
	public List<AddPartyEntity> getAllParties(){
		List<AddPartyEntity> addAll=addPartyRepo.findAll();
		return addAll;
	}
	 
	///////////////////Partial Update////////////////////////////////
	public AddPartyEntity updateAddparty (long AdId, AddPartyEntity addparty) {
		AddPartyEntity updatepartial = addPartyRepo.findById(AdId).orElseThrow();
		
		Optional.ofNullable(addparty.getCustomerName()).ifPresent(updatepartial::setCustomerName);
		Optional.ofNullable(addparty.getMobileNumber()).ifPresent(updatepartial::setMobileNumber);
		Optional.ofNullable(addparty.getBillingAddress()).ifPresent(updatepartial::setBillingAddress);
		Optional.ofNullable(addparty.getState()).ifPresent(updatepartial::setState);
		Optional.ofNullable(addparty.getPincode()).ifPresent(updatepartial::setPincode);
		Optional.ofNullable(addparty.getCity()).ifPresent(updatepartial::setCity);
		Optional.ofNullable(addparty.getShippingAddress()).ifPresent(updatepartial::setShippingAddress);
		Optional.ofNullable(addparty.getShippingCity()).ifPresent(updatepartial::setShippingCity);
		Optional.ofNullable(addparty.getShippingState()).ifPresent(updatepartial::setShippingState);
		Optional.ofNullable(addparty.getPincode()).ifPresent(updatepartial::setShippingPincode);
		Optional.ofNullable(addparty.getGstIn()).ifPresent(updatepartial::setGstIn);
		return addPartyRepo.save(updatepartial);
		
	}

	///////////////////////Delete AddParty//////////////////////////////////////
	public void deleteByPartyId(long AdId) {
		addPartyRepo.deleteById(AdId);
	}

}
