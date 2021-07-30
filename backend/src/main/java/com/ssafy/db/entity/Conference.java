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

//컨퍼런스 정보
@Entity
@Getter
@Setter
public class Conference extends BaseEntity {

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Category> category;

	@OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	private List<User_Conference> user;
	
	private Date call_start_time;
	private Date call_end_time;
	private String thumbnail_url;
	private String title;
	private String description;
	private Boolean is_active;

	@PrePersist
	public void createdAt() {
		this.call_start_time = new Date();
	}
}
