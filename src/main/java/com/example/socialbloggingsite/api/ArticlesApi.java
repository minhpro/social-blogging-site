package com.example.socialbloggingsite.api;

import com.example.socialbloggingsite.api.exception.ResourceNotFoundException;
import com.example.socialbloggingsite.application.article.ArticleData;
import com.example.socialbloggingsite.application.article.ArticleService;
import com.example.socialbloggingsite.application.article.NewArticleParam;
import com.example.socialbloggingsite.core.article.Article;
import com.example.socialbloggingsite.core.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/articles")
@Slf4j
public class ArticlesApi {

	private ArticleService articleService;

	@Autowired
	public ArticlesApi(ArticleService articleService) {
		this.articleService = articleService;
	}

	@PostMapping
	public Article createArticle(
			@Valid @RequestBody NewArticleParam newArticleParam, @AuthenticationPrincipal User user) {
		log.info("Create article by: " + user.getUsername());
		return articleService.createArticle(newArticleParam, user);
	}

	@GetMapping(path = "/{slug}")
	public ArticleData article(
			@PathVariable("slug") String slug, @AuthenticationPrincipal User user) {
		return articleService
				.getArticleBySlug(slug)
				.orElseThrow(ResourceNotFoundException::new);
	}
}
