package com.okta.springbootvue.repository;

import com.okta.springbootvue.entity.DoctorProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DoctorProfileR extends JpaRepository<DoctorProfile, Long> {
    DoctorProfile findById(long id);
}