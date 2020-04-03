package com.example.companyclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.companyclient.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
