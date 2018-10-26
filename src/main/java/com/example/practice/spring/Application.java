package com.example.practice.spring;

import com.example.practice.spring.Model.UserVO;
import com.example.practice.spring.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		UserVO user = new UserVO("test4", "test4", "1q2w3e3");
		log.error(userRepository.getUserInfoAll().toString());

		userRepository.addUserInfo(user);
		log.error(userRepository.getUserInfoAll().toString());

		log.error("like 이름 검색");
		log.error(userRepository.findByUserNameLike("kim").toString());

		log.error("단 건 조회");
		log.error(userRepository.findByUserNameLike("kim2").toString());
	}
}
