package com.example.companyclient.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	
	@NotNull
	private String companyName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "company")
	private List<Client> clients = new ArrayList<Client>();

	public Company() {
		super();
	}
	
	public Company(String companyName, List<Client> clients) {
		super();
		this.companyName = companyName;
		this.clients = clients;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", clients=" + clients + "]";
	}

}
