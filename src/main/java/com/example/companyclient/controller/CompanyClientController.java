package com.example.companyclient.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.companyclient.dto.ErrorDto;
import com.example.companyclient.entity.Client;
import com.example.companyclient.entity.Company;
import com.example.companyclient.exceptions.ServiceException;
import com.example.companyclient.service.serviceimpl.CommonServiceImpl;

@RestController
@RequestMapping("/companyclient")
public class CompanyClientController {


	@Autowired
	private CommonServiceImpl service;
	
	private ErrorDto createErrorDto(Exception e) {
		ErrorDto dto = new ErrorDto();
		dto.setErrorType(e.getClass().getCanonicalName());
		dto.setMessage(e.getMessage());
		return dto;
	}

	@PostMapping("/company")
	public ResponseEntity<?> createCompany(@RequestBody Company company) {
		Company company2 = null; 
		try {
			company2 = service.addCompany(company);
		} catch(ServiceException e) {
			return new ResponseEntity<ErrorDto>(createErrorDto(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Company>(company2, HttpStatus.OK);
	}

	@PostMapping(path = "/client/{companyId}")
	public ResponseEntity<?> addClientsToCompany(@PathVariable int companyId, @RequestBody List<Client> clients) {
		Company company = null;
		try {
			company = service.addClientsToCompany(clients, companyId);
		} catch(ServiceException e) {
			return new ResponseEntity<ErrorDto>(createErrorDto(e), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);

	}
	
	@GetMapping("/clients/{companyId}")
	public ResponseEntity<?> getAllClientsByCompanyId(@PathVariable int companyId) {
		List<Client> clients = new ArrayList<Client>();
		try {
			clients = service.getAllClientsByCompanyId(companyId);
		} catch (ServiceException e) {
			return new ResponseEntity<ErrorDto>(createErrorDto(e), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	
	@PutMapping("/client/{clientId}/{newBudget}")
	public ResponseEntity<?> updateBudget(@PathVariable int clientId, @PathVariable double newBudget) {
		Client client = null;
		try {
			client = service.updateClientBudgetById(clientId, newBudget);
			
		} catch(ServiceException e) {
			return new ResponseEntity<ErrorDto>(createErrorDto(e), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@DeleteMapping("/company/{companyId}")
	public ResponseEntity<?> deleteCompany(@PathVariable int companyId) {
		Company company = null;
		try {
			company = service.deleteCompany(companyId);
		} catch (ServiceException e) {
			return new ResponseEntity<ErrorDto>(createErrorDto(e), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
}
