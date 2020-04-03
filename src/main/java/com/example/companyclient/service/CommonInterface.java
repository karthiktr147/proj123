package com.example.companyclient.service;

import java.util.List;

import com.example.companyclient.entity.Client;
import com.example.companyclient.entity.Company;
import com.example.companyclient.exceptions.ServiceException;

public interface CommonInterface {

	public Company addCompany(Company company) throws ServiceException;
	public Company addClientsToCompany(List<Client> clients, int companyId) throws ServiceException;
	public List<Client> getAllClientsByCompanyId(int companyId) throws ServiceException;
	public Client updateClientBudgetById(int clientId, double newBuddget) throws ServiceException;
	public Company deleteCompany(int companyId) throws ServiceException;
	
}
