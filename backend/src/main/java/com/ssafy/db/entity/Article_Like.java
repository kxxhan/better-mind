package com.ssafy.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Article_Like extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Community_Article article;
}
