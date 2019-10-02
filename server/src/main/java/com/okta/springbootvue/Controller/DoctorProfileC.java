package com.okta.springbootvue.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.okta.springbootvue.entity.DoctorProfile;
import com.okta.springbootvue.entity.Title;
import com.okta.springbootvue.entity.Expertise;
import com.okta.springbootvue.entity.Sex;
import com.okta.springbootvue.entity.Province;
import com.okta.springbootvue.repository.DoctorProfileR;
import com.okta.springbootvue.repository.TitleR;
import com.okta.springbootvue.repository.ExpertiseR;
import com.okta.springbootvue.repository.SexR;
import com.okta.springbootvue.repository.ProvinceR;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class DoctorProfileC {
    @Autowired
    private final DoctorProfileR profileR;
    @Autowired
    private TitleR titleR;
    @Autowired
    private ExpertiseR expertiseR;
    @Autowired
    private SexR sexR;
    @Autowired
    private ProvinceR provinceR;

    DoctorProfileC(DoctorProfileR profileR) {
        this.profileR = profileR;
    }

    @GetMapping("/doctorprofile")
    public Collection<DoctorProfile> ProfileS() {
        return profileR.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/doctorprofile/{address}/{age}/{birthday}/{exp}/{fname}/{graduate}/{lname}/{id_card}/{expertise_id}/{sex_id}/{title_id}/{province_id}")
    public DoctorProfile newProfile(DoctorProfile newProfile,
    @PathVariable String address,
    @PathVariable Integer age,
    @PathVariable String exp,
    @PathVariable String fname,
    @PathVariable Date birthday,
    @PathVariable String graduate,
    @PathVariable String lname,
    @PathVariable long id_card,
    @PathVariable long title_id,
    @PathVariable long expertise_id,
    @PathVariable long sex_id,
    @PathVariable long province_id
    ) {

    Title title = titleR.findById(title_id);
    Expertise expertise = expertiseR.findById(expertise_id);
    Sex sex = sexR.findById(sex_id);
    Province province = provinceR.findById(province_id);
   
    newProfile.setTitle(title);
    newProfile.setExpertise(expertise);
    newProfile.setSex(sex);
    newProfile.setProvince(province);

    return profileR.save(newProfile); 
    
    }
}
