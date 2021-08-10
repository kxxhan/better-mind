package com.ssafy.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.api.response.UserProgramGetRes;
import com.ssafy.db.entity.User_Program;
import com.ssafy.db.repository.User_ProgramRepository;

@Service("userprogramService")
public class UserProgramServiceImpl implements UserProgramService {

	@Autowired
	User_ProgramRepository userprogramRepository;
	
	@Override
	public User_Program createUserProgram(UserProgramPostReq userprogramPostReq) {
		User_Program userprogram = new User_Program();
//		userprogram.setUser(userprogramRepository.findByUser_id(userprogramPostReq.getUser_id()));
//		userprogram.setProgram(userprogramRepository.findByProgram_id(userprogramPostReq.getProgram_id()));
		userprogram = userprogramRepository.save(userprogram);
		return userprogram;
	}

	@Override
	public void deleteUserProgram(Long id) {
		userprogramRepository.deleteById(id);
	}

	@Override
	public UserProgramGetRes getOneUserProgram(Long id) {
		User_Program userprogram = userprogramRepository.findById(id).get();
		UserProgramGetRes up = new UserProgramGetRes();
		up.setUser_id(userprogram.getUser().getId());
		up.setProgram_id(userprogram.getProgram().getId());
		return up;
	}

	@Override
	public List<UserProgramPostReq> getAllUserProgram(Pageable pageable) {
		List<User_Program> list = userprogramRepository.findAll(pageable).getContent();
		List<UserProgramPostReq> copy = new ArrayList<>();
		UserProgramPostReq resp;
		for(User_Program up : list) {
			resp = new UserProgramPostReq();
			resp.setUser_id(up.getUser().getId());
			resp.setProgram_id(up.getProgram().getId());
			copy.add(resp);
		}
		return copy;
	}

}
