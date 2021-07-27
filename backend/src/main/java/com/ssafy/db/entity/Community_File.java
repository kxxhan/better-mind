package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 게시판 파일 모델 정의.
 */

@Entity
@Getter
@Setter
public class Community_File extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id")
	private Community_Article article;
	
	private String savefolder;
	private String originfile;
	private String savefile;
	
}
