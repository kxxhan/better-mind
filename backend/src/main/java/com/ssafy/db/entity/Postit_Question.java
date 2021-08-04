package com.ssafy.db.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

/**
 * 포스트잇 질문 모델 정의.
 */

@Entity
@Getter
@Setter
public class Postit_Question extends BaseEntity {

	private String content;
	private Date created_at;
	private Date updated_at;
	
	@PrePersist
	public void createdAt() {
		this.created_at = new Date();
		this.updated_at = new Date();
	}
	
}
