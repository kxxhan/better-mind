package com.ssafy.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserProgramPostReq;
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
	ProgramRepository programRepository;
	
	@Override
	public User_Program createUserProgram(UserProgramPostReq userprogramPostReq) throws IllegalStateException, IOException{
		User_Program userprogram = new User_Program();
		userprogram.setUser(userprogramPostReq.getUser_id()); //왜 null값들어감 ㅡㅡ?
		userprogram.setProgram(userprogramPostReq.getProgram_id());
//		System.out.println(userprogramPostReq.getUser_id());
//		System.out.println(userprogramPostReq.getProgram_id());
//		userprogram.setUser(userprogramRepository.findByUser_id(userprogramPostReq.getUser_id()));
//		userprogram.setProgram(userprogramRepository.findByProgram_id(userprogramPostReq.getProgram_id()));
//		userprogram.setUser(userRepository.findByUser_id(userprogramPostReq.getUser_id().getLong(null)));
//		userprogram.setUser(userprogramRepository.findByUserid(userprogramPostReq.getUser_id()));
//		userprogram.setProgram(userprogramRepository.findByProgramid(userprogramPostReq.getProgram_id()));
//		System.out.println(userprogramRepository.save(userprogram));
		userprogram = userprogramRepository.save(userprogram);
		return userprogram;
	}

	@Override
	public void deleteUserProgram(Long id) {
		userprogramRepository.deleteById(id);
	}

}
