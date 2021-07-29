package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 프로그램 후기 모델 정의.
 */

@Entity
@Getter
@Setter
public class Program_Review extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	private String content;
	
}
