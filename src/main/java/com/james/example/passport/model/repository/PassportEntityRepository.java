package com.james.example.passport.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.james.example.passport.model.entity.PassportEntity;

public interface PassportEntityRepository extends CrudRepository<PassportEntity, String> {

	public PassportEntity findByFirstNameAndLastName(String firstName, String lastName);
	
	public PassportEntity findByDocNo(String docNo);
}
