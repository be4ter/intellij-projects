package com.example.pasing.controller;

import com.example.pasing.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {
	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("")
	public String index(Model model, Pageable pageable) {
		model.addAttribute("articleList", articleRepository.findAll(pageable));
		return "index";
	}

	@GetMapping("/{page}/{size}")
	public String index(Model model, Pageable pageable, @PathVariable(value = "page") String page, @PathVariable(value = "size") String size) {
//		Pageable pageable = new QPageRequest(page, size);
		model.addAttribute("articleList", articleRepository.findAll(pageable));
		return "index";
	}

	@GetMapping("/{article}")
	public String index(Model model, Pageable pageable, @PathVariable String article) {
		model.addAttribute("articleList", articleRepository.findAll(pageable));
		return "index";
	}
}
