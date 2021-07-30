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
 * 게시판 모델 정의.
 */

@Entity
@Getter
@Setter
public class Community_Article extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinColumn
	private List<Community_Comment> comment;
	
	@OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinColumn
	private List<Community_File> file;
	
	private String title;
	private String content;
	private Date created_at;
	private Date updated_at;
	
	@PrePersist
	public void createdAt() {
		this.created_at = new Date();
		this.updated_at = new Date();
	}
	
}

