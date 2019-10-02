package com.okta.springbootvue;

import java.util.stream.Stream;

import com.okta.springbootvue.entity.Title;
import com.okta.springbootvue.entity.Expertise;
import com.okta.springbootvue.entity.Sex;
import com.okta.springbootvue.entity.Province;
import com.okta.springbootvue.repository.TitleR;
import com.okta.springbootvue.repository.ExpertiseR;
import com.okta.springbootvue.repository.SexR;
import com.okta.springbootvue.repository.ProvinceR;

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
                            SexR sexRepository, ProvinceR provinceRepository){
		return args -> {
			Stream.of("นายแพทย์","แพทย์หญิง","เทคนิคการแพทย์","เทคนิคการแพทย์หญิง","ทันตแพทย์","ทันตแพทย์หญิง").forEach(TitleNames-> {
				Title title = new Title();
			    title.setTitle(TitleNames);
				titleRepository.save(title);
			});

			Stream.of("หู คอ จมูก","กระดูก ข้อ","จักษุวิทยา","อายุรศาสตร์","ประสาทวิทยา","รังสีวิทยา","พยาธิวิทยา","ศัลยกรรม","กุมารเวชศาสตร์","เวชศาสตร์ฟื้นฟู","จิตเวชศาสตร์").forEach(skills-> {
				Expertise expertise = new Expertise();
				expertise.setExpertise(skills);
				expertiseRepository.save(expertise);
            });
            
            Stream.of("ชาย","หญิง").forEach(gender -> {
				Sex sex = new Sex();
				sex.setSex(gender);
				sexRepository.save(sex);
			});

			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท"
			, "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช"
			, "นครสวรรค์", "นนทบุรี", "นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา"
			, "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่", "พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน"
			, "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง", "ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล"
			, "สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย"
			, "หนองบัวลำภู", "อ่างทอง", "อุดรธานี", "อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(provinces -> {
				Province province = new Province();
				province.setProvince(provinces);
				provinceRepository.save(province);
			});

			titleRepository.findAll().forEach(System.out::println);
			expertiseRepository.findAll().forEach(System.out::println);
			sexRepository.findAll().forEach(System.out::println);
			provinceRepository.findAll().forEach(System.out::println);
		};
	}
}
