package com.example.pasing.controller;

import com.example.pasing.model.Article;
import com.example.pasing.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiMainClass {
	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping()
	public Page<Article> getArticle(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}
}
