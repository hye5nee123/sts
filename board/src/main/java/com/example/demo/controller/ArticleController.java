package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ArticleForm;

@Controller
public class ArticleController {
	@GetMapping("/new")
	public String newArticleForm() {
		return "articles/new";
	}

	@PostMapping("/articles/create")
	public String createArticleForm(ArticleForm form) {
		System.out.println(form.toString());
		return "";
	}
}
