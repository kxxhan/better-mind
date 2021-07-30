package com.ssafy.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Category> category;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Program_Review> review;
	
	private String report; // 프로그램 소개
	private int price;
	private int count; // 프로그램 횟수
	private String time; // 프로그램 날짜, 요일, 시간 = 일정
	
	@OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinColumn
	private List<Program_File> file;
	
	
	
}
