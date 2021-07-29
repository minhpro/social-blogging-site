package com.example.socialbloggingsite.core.article;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Article {
	private String userId;
	private String id;
	private String title;
	private String slug;
	private String description;
	private String body;
	private List<Tag> tags;
	private DateTime createdAt;
	private DateTime updatedAt;
}
