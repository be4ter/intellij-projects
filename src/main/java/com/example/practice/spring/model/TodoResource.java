package com.example.practice.spring.model;

import org.springframework.hateoas.ResourceSupport;

// hateoas를 이용한 uri정보 표현

public class TodoResource extends ResourceSupport {
	private String title;

	public TodoResource() {
	}

	public TodoResource(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
