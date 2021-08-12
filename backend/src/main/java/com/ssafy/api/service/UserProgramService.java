package com.ssafy.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.api.response.UserProgramGetRes;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.User_Program;

public interface UserProgramService {
	
	User_Program createUserProgram(UserProgramPostReq userprogramPostReq) throws IllegalStateException, IOException;
	
	void deleteUserProgram(Long id);
	
}
