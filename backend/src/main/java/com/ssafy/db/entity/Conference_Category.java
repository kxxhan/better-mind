package com.ssafy.db.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

//컨퍼런스 종류

@Entity
@Getter
@Setter
public class Conference_Category extends BaseEntity {
	private String name;
}
