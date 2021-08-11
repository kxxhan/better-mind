package com.ssafy.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.api.response.UserProgramGetRes;
import com.ssafy.db.entity.User_Program;

public interface UserProgramService {
	
	User_Program createUserProgram(UserProgramPostReq userprogramPostReq);
	
	void deleteUserProgram(Long id);
	
//	UserProgramGetRes getOneUserProgram(Long id);
//	
//	List<UserProgramPostReq> getAllUserProgram(Pageable pageable);
	
}
