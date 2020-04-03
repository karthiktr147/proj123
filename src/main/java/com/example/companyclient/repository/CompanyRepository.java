package com.example.companyclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.companyclient.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
