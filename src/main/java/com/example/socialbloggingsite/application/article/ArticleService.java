package com.example.socialbloggingsite.application.article;

import com.example.socialbloggingsite.core.article.Article;
import com.example.socialbloggingsite.core.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

	public Article createArticle(NewArticleParam articleParam, User user) {
		// TODO
		return null;
	}

	public Optional<ArticleData> getArticleBySlug(String slug) {
		// TODO
		return Optional.empty();
	}
}
