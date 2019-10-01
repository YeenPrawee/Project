package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.Expertise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ExpertiseR extends JpaRepository<Expertise, Long> {
	Expertise findById(long id);
}