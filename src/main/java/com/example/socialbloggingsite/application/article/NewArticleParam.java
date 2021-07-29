package com.example.socialbloggingsite.application.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class NewArticleParam {
	private String title;
	private String description;
	private String body;
	private List<String> tags;
}
