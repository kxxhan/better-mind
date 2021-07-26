package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

/**
 * 게시판 모델 정의.
 */

@Entity
@Getter
@Setter
public class Community_article extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User userId;
	
	private String title;
	private String content;
	private Date created_at;
	private Date updated_at;
	
	@PrePersist
	public void createdAt() {
		this.created_at = new Date();
	}
	
	@PrePersist
	public void updatedAt() {
		this.updated_at = new Date();
	}
}

