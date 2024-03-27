package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;

@Controller
public class ArticleController {
	Article article = form.toEntity();

	@GetMapping("/articles/neww")
	public void neww() {

	}

	@PostMapping("/articles/create")
	public String createArticle(ArticleForm form) {
		System.out.println(form.toString());
		return "";
	}

}
