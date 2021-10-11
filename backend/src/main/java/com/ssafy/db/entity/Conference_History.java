package com.ssafy.db.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Conference_History extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Conference conference;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;

	private Short action;

	private Date inserted_time;

	@PrePersist
	public void createdAt() {
		this.inserted_time = new Date();
	}
}
