package com.example.socialbloggingsite.application.article;

import com.example.socialbloggingsite.application.user.UserData;
import com.example.socialbloggingsite.core.article.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

@Data
@NoArgsConstructor
public class ArticleData {
	private String id;
	private String title;
	private String description;
	private String body;
	private List<Tag> tags;
	private DateTime createdAt;
	private DateTime updatedAt;

	private UserData author;
}
