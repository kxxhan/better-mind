package com.ssafy.db.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Data
public class User_Program extends BaseEntity {
	//ManyToOne은 즉시 로딩이 기본값인데 연결된 엔티티 정보까지 한 번에 가져오려고 해서 성능에 문제가 발생할 수 있다.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id")
	private Program program;
	
//	private Long myProgram_id;
	
	public void setUser(User user) {
		this.user=user;
	}
	
	public void setProgram(Program program) {
		this.program=program;
	}

//	public void setProgram(Long myprogram_id) {
//		this.myProgram_id=myprogram_id;	
//	}
	
}
