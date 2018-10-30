package com.example.pasing.controller;

import com.example.pasing.model.Article;
import com.example.pasing.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired
	private ArticleRepository articleRepository;

//		@GetMapping("")
//		public List<Article> get() {
//			return articleRepository.findAll();
//		}

	@GetMapping("/list/atricle")
	public Page<Article> findFirst10ByJob(Pageable pageable) {
//		PageRequest pageRequest =
//				new PageRequest(0, 10);
//		return articleRepository.findAll(pageRequest);
		return articleRepository.findAll(pageable);
	}
}
