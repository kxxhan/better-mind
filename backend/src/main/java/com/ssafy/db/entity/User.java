package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * 유저 모델 정의.
 */
//Entity가 붙은 클래스는 JPA가 관리하는 클래스이고, 테이블과 매핑할 테이블에 해당 어노테이션을 붙인다.
@Entity
@Getter
@Setter
public class User extends BaseEntity {
	private String position;
	private String department;
	private String name;
	private String userId;
	private String role;

	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
}
