package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 프로그램 모델 정의.
 */

@Entity
@Getter
@Setter
public class Program extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expert_id")
	private Expert expert;
	
	private String name;
	private String category;
	private String report; // 프로그램 소개
	private int price;
	private int count; // 프로그램 횟수
	private String time; // 프로그램 날짜, 요일, 시간 = 일정
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private Program_File file;
	
}
