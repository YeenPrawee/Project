package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProvinceR extends JpaRepository<Province, Long> {
    Province findById(long id);
}