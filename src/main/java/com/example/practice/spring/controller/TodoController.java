package com.example.practice.spring.controller;

import com.example.practice.spring.model.Todo;
import com.example.practice.spring.model.TodoResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/basic")
public class TodoController {
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/todo")
	public Todo basic() {
		return new Todo(counter.incrementAndGet(), "라면사오기");
	}

	@PostMapping("/todop")
	public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
		return new Todo(counter.incrementAndGet(), todoTitle);
	}

	@PostMapping("/todor")
	public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle) {
		return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
	}

	@GetMapping("/todoh/{todoTitle}")
	public ResponseEntity<TodoResource> geth(@PathVariable String todoTitle) {
		TodoResource todoResource = new TodoResource(todoTitle);
		todoResource.add(linkTo(methodOn(TodoController.class).geth(todoTitle)).withSelfRel());
		return new ResponseEntity(todoResource, HttpStatus.OK);
	}
}