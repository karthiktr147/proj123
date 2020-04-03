package com.example.companyclient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "Client")
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	
	@NotNull
	@Column
	private String clientName;
	
	private double clientBudget;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;

	public Client() {
		super();
	}

	public Client(@NotNull String clientName, double clientBudget, Company company) {
		super();
		this.clientName = clientName;
		this.clientBudget = clientBudget;
		this.company = company;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getClientBudget() {
		return clientBudget;
	}

	public void setClientBudget(double clientBudget) {
		this.clientBudget = clientBudget;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientBudget=" + clientBudget
				+ ", company=" + company + "]";
	}
}
