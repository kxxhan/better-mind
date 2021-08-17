package com.ssafy.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

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
	@JoinColumn
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<User_Program> users;
	
	private String name;
	private String description; // 전문가 소개
	private String report; // 프로그램 소개
	private int price;
	private int count; // 프로그램 횟수
	private String date; // 날짜
	private String time; // 시간
	private Enum<CategoryEnum> category;
	private String type; // 화상미팅 타입
	
	// 화상미팅 관련 ... 수정필요
	private Boolean isactive;
//	private Date call_start_time;
//	private Date call_end_time;
	
//	@PrePersist
//	public void createdAt() {
//		this.call_start_time = new Date();
//	}
}
