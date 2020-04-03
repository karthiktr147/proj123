package com.example.companyclient.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.companyclient.entity.Client;
import com.example.companyclient.entity.Company;
import com.example.companyclient.exceptions.NoClientPresentException;
import com.example.companyclient.exceptions.NoSuchCompanyException;
import com.example.companyclient.exceptions.ServiceException;
import com.example.companyclient.repository.ClientRepository;
import com.example.companyclient.repository.CompanyRepository;
import com.example.companyclient.service.CommonInterface;

@Service
public class CommonServiceImpl implements CommonInterface {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company addCompany(Company company) throws ServiceException {
		Company company2 = null;
		try {
			company2 = companyRepository.save(company);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return company2;
	}

	@Override
	public Company addClientsToCompany(List<Client> clients, int companyId) throws ServiceException {
		
		Company company = companyRepository.findById(companyId).orElse(null);
		
		if(company != null) {
			clients.forEach(client -> {
				client.setCompany(company);
			});
			company.setClients(clients);
			companyRepository.save(company);
		} else {
			throw new NoSuchCompanyException("No company with id : " + companyId + " exists");
		}
		return company;
	}

	@Override
	public List<Client> getAllClientsByCompanyId(int companyId) throws ServiceException {
		
		Company company = companyRepository.findById(companyId).orElse(null);
		
		List<Client> clients = new ArrayList<Client>();
		
		if(company != null) {
			clients = company.getClients();
		} else {
			throw new NoSuchCompanyException("No company with id : " + companyId + " exists");
		}
		
		if(clients.size() == 0) {
			throw new NoClientPresentException("No client for company with id : " + companyId + " exists");
		}
		return clients;
	}

	@Override
	public Client updateClientBudgetById(int clientId, double newBudget) throws ServiceException {
		
		Client client = clientRepository.findById(clientId).orElse(null);
		
		if(client != null) {
			client.setClientBudget(newBudget);
			client = clientRepository.save(client);
		} else {
			throw new NoClientPresentException("No company with id : " + clientId + " exists");
		}
		
		return client;
	}

	@Override
	public Company deleteCompany(int companyId) throws ServiceException {
		
		Company company = companyRepository.findById(companyId).orElse(null);
		if(company != null) {
			companyRepository.delete(company);
		} else {
			throw new NoSuchCompanyException("No company with id : " + companyId + " exists");
		}
		return company;
	}

}
