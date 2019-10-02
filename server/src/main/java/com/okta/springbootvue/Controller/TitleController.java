package com.okta.springbootvue.Controller;

import com.okta.springbootvue.entity.Title;
import com.okta.springbootvue.repository.TitleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TitleController {

    @Autowired
    private final TitleR titleR;

    public TitleController(TitleR titleR) {
        this.titleR = titleR;
    }

    @GetMapping("/title")
    public Collection<Title> Titles() {
        return titleR.findAll().stream().collect(Collectors.toList());
    }

}