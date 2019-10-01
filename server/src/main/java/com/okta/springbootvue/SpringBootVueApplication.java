package com.okta.springbootvue;

import java.util.stream.Stream;

import com.okta.springbootvue.entity.Title;
import com.okta.springbootvue.entity.Expertise;
import com.okta.springbootvue.entity.Sex;
import com.okta.springbootvue.repository.TitleR;
import com.okta.springbootvue.repository.ExpertiseR;
import com.okta.springbootvue.repository.SexR;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
    ApplicationRunner init(TitleR titleRepository, ExpertiseR expertiseRepository,
                            SexR sexRepository){
		return args -> {
			Stream.of("นายแพทย์","แพทย์หญิง").forEach(TitleNames-> {
				Title title = new Title();
			    title.setTitle(TitleNames);
				titleRepository.save(title);
			});

			Stream.of("หู ตา จมูก","กระดูก").forEach(skills-> {
				Expertise expertise = new Expertise();
				expertise.setExpertise(skills);
				expertiseRepository.save(expertise);
            });
            
            Stream.of("ชาย","หญิง").forEach(gender -> {
				Sex sex = new Sex();
				sex.setSex(gender);
				sexRepository.save(sex);
			});

			titleRepository.findAll().forEach(System.out::println);
			expertiseRepository.findAll().forEach(System.out::println);
			sexRepository.findAll().forEach(System.out::println);
		};
	}
}
