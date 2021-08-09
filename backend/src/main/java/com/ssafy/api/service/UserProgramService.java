package com.ssafy.api.service;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.db.entity.User_Program;

public interface UserProgramService {
	User_Program createUserProgram(UserProgramPostReq userprogramPostReq);
	void deleteUserProgram(Long id);
}
