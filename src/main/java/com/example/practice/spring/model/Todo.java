package com.example.practice.spring.model;

public class Todo {
	private long id;
	private String title;

	public Todo() {
	}

	public Todo(long id, String title) {
		this.id = id;
		this.title = title;
	}


	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

}
