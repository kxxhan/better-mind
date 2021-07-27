package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 프로그램 후기 모델 정의.
 */

@Entity
@Getter
@Setter
public class Program_Review extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id")
	private Program program_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_name")
	private Program program_name;
	
	private String content;
	
}
