package com.ssafy.db.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

/**
 * 게시판 모델 정의.
 */

@Entity
@Getter
@Setter
public class Community_Article extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;

	private String title;
	private String content;
	
	@Column(name = "like_count")
	private Integer like;
	
	private Date created_at;
	private Date updated_at;
	private Enum<CategoryEnum> category;

	@PrePersist
	public void createdAt() {
		this.created_at = new Date();
		this.updated_at = new Date();
		this.like = 0;
	}

}
