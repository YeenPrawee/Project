package com.okta.springbootvue.Controller;

import com.okta.springbootvue.entity.Sex;
import com.okta.springbootvue.repository.SexR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SexC {

    @Autowired
    private final SexR sexR;

    public SexC(SexR sexR) {
        this.sexR = sexR;
    }

    @GetMapping("/sex")
    public Collection<Sex> Sexs() {
        return sexR.findAll().stream().collect(Collectors.toList());
    }

}