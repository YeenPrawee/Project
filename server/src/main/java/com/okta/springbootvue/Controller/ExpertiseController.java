package com.okta.springbootvue.Controller;

import com.okta.springbootvue.entity.Expertise;
import com.okta.springbootvue.repository.ExpertiseR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ExpertiseController {

    @Autowired
    private final ExpertiseR expertiseR;

    public ExpertiseController(ExpertiseR expertiseR) {
        this.expertiseR = expertiseR;
    }

    @GetMapping("/expertise")
    public Collection<Expertise> Expertises() {
        return expertiseR.findAll().stream().collect(Collectors.toList());
    }

}