package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 프로그램 파일 모델 정의.
 */

@Entity
@Getter
@Setter
public class Program_File extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Program program;
	
	private String savefolder;
	private String originfile;
	private String savefile;
	
}
