package com.okta.springbootvue.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "DoctorProfile")
public class DoctorProfile {

    @Id
    @SequenceGenerator(name = "DoctorProfile_SEQ", sequenceName = "DoctorProfile_SEQ",initialValue = 20001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DoctorProfile_SEQ")
    @Column(name = "DoctorProfile_ID", unique = true, nullable = true)
    private @NonNull Long id;  
   
    private @NonNull long id_card;
    private @NonNull String fname;
    private @NonNull String lname;
    private @NonNull Date birthday;
    private @NonNull Integer age;
    private @NonNull String address;
    private @NonNull String exp;
    private @NonNull String graduate;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Title.class)
    @JoinColumn(name = "Title_ID", insertable = true)
    private Title title;

    @ManyToOne(fetch =  FetchType.EAGER, targetEntity = Expertise.class)
    @JoinColumn(name = "Expertise_ID",insertable = true)
    private Expertise expertise;
    
    @ManyToOne(fetch =  FetchType.EAGER, targetEntity = Sex.class)
    @JoinColumn(name = "Sex_ID",insertable = true)
    private Sex sex;

    @ManyToOne(fetch =  FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID",insertable = true)
    private Province province;
}