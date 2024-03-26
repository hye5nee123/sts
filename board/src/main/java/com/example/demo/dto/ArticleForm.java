package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleForm {
	private String title;
	private String content;

	@Override
	public String toString() {
		return "ArticleForm{" + "title='" + title + '\'' + ", content'" + content + '\'' + '}';
	}

}
