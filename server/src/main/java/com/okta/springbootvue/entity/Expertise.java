package com.okta.springbootvue.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Expertise")
public class Expertise {

    @Id 
    @SequenceGenerator(name="Expertise_seq",sequenceName="Expertise_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Expertise_seq")
    @Column(name = "Expertise_ID", unique = true, nullable = true)
    private @NonNull Long id;    
    private @NonNull String expertise;
    
    
}