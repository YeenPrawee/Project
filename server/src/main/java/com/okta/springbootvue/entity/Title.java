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
@Table(name = "Title")
public class Title {

    @Id
    @SequenceGenerator(name = "Title_SEQ", sequenceName = "Title_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_SEQ")
    @Column(name = "Title_ID", unique = true, nullable = true)

    private @NonNull Long id;
    private @NonNull String title;

}