package com.example.practice.spring;

import com.example.practice.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiTest {
	private static final Logger log = LoggerFactory.getLogger(RestApiTest.class);
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetUserById() {
		String url = "http://localhost:8080/user/0";
		User user = testRestTemplate.getForObject(url, User.class);
		log.error("등록일 : " + user.getRegDate() + "," + user.getUserId());
	}

	@Test
	public void testGetUserList() {
		String url = "http://localhost:8080/user";
		ResponseEntity<Map<String, List<User>>> responseEntity = testRestTemplate.exchange(
				url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, List<User>>>() {
				});
		log.error(responseEntity.toString());
	}
}
