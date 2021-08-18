package com.ssafy.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.User_Program;
import com.ssafy.db.repository.ProgramRepository;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.User_ProgramRepository;

@Service("userprogramService")
public class UserProgramServiceImpl implements UserProgramService {

	@Autowired
	User_ProgramRepository userprogramRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	ProgramRepository programRepository;
	
	@Override
	@Transactional
	public User_Program createUserProgram(UserProgramPostReq userprogramPostReq) throws IllegalStateException, IOException{
		User_Program userprogram = new User_Program();
		User user = userService.findByUserId(userprogramPostReq.getUser_id()); // 유저 서비스에서 유저 객체 찾기
		userprogram.setUser(user); // 유저 프로그램의 유저 셋팅
		Program program = programService.findByProgramId(userprogramPostReq.getProgram_id()); // 프로그램 서비스에서 프로그램 객체 찾기
		userprogram.setProgram(program); // 유저 프로그램의 프로그램 셋팅
//		userprogram.setMyProgram_id(userprogramPostReq.getMyProgram_id());
		userprogram = userprogramRepository.save(userprogram);
		return userprogram;
	}

	@Override
	public void deleteUserProgram(Long id) {
		userprogramRepository.deleteById(id);
	}

}
