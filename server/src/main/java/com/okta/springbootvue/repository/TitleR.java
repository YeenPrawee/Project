package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.Title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public 
interface TitleR extends JpaRepository<Title, Long> {
    Title findById(long id);
}