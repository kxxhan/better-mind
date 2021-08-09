package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.db.entity.User_Program;
import com.ssafy.db.repository.User_ProgramRepository;

@Service("userprogramService")
public class UserProgramServiceImpl implements UserProgramService {

	@Autowired
	User_ProgramRepository userprogramRepository;
	
	@Override
	public User_Program createUserProgram(UserProgramPostReq userprogramPostReq) {
		User_Program userprogram = new User_Program();
		userprogram.setUser(userprogramRepository.findByUserid(userprogramPostReq.getUser_id().get()));
		userprogram.setProgram(userprogramPostReq.getProgram_id());
		userprogram = userprogramRepository.save(userprogram);
		return userprogram;
	}

	@Override
	public void deleteUserProgram(Long id) {
		userprogramRepository.deleteById(id);
	}

}
