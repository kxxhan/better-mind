package com.ssafy.db.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

/**
 * 포스트잇 답변 모델 정의.
 */

@Entity
@Getter
@Setter
public class Postit_Answer extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Postit_Question postitquestion;
	
	private String content;
	private Date created_at;
	private Date updated_at;
	
	@PrePersist
	public void createdAt() {
		this.created_at = new Date();
		this.updated_at = new Date();
	}
}
