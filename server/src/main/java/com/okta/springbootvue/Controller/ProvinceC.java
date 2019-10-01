package com.okta.springbootvue.Controller;

import com.okta.springbootvue.entity.Province;
import com.okta.springbootvue.repository.ProvinceR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinceC {

    @Autowired
    private final ProvinceR provinceR;

    public ProvinceC(ProvinceR provinceR) {
        this.provinceR = provinceR;
    }

    @GetMapping("/province")
    public Collection<Province> Provinces() {
        return provinceR.findAll().stream().collect(Collectors.toList());
    }

}