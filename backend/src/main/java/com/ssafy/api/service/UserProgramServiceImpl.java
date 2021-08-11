package com.ssafy.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.UserProgramGetRes;
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
	ProgramRepository programRepository;
	
	@Override
	public User_Program createUserProgram(UserProgramPostReq userprogramPostReq) {
		User_Program userprogram = new User_Program();
//		userprogram.setUser(userprogramPostReq.getUser_id());
//		userprogram.setProgram(userprogramPostReq.getProgram_id());
//		userprogram.setProgram(userprogramRepository.findByProgram_id(userprogramPostReq.getProgram_id()));
		userprogram = userprogramRepository.save(userprogram);
		return userprogram;
	}

	@Override
	public void deleteUserProgram(Long id) {
		userprogramRepository.deleteById(id);
	}

	@Override
	public List<Program> getOneUserProgram(Long user_id) {
		return userprogramRepository.findProgramListByUser_id(user_id);
	}

//	@Override
//	public UserProgramGetRes getOneUserProgram(Long user_id) {
//		Long uid = userprogramRepository.findByUser_id(user_id).get().getId();
////		User_Program userprogram = userprogramRepository.findById(id).get();
//		UserProgramGetRes up = new UserProgramGetRes();
//		up.setProgram_id(userprogram.getProgram().getId());
//		List<User> ulist = userRepository.findByProgram_id(userprogram.getProgram().getId());
//		if(ulist != null) {
//			List<UserRegisterPostReq> users = new ArrayList<>();
//			for(User k : ulist) {
//				UserRegisterPostReq u = new UserRegisterPostReq();
//				u.setId(k.getId());
//				users.add(u);
//			}
//			up.setUsers(users);
//		}
//		return up;
//	}
//
//	@Override
//	public List<UserProgramPostReq> getAllUserProgram(Pageable pageable) {
//		List<User_Program> list = userprogramRepository.findAll(pageable).getContent();
//		List<UserProgramPostReq> copy = new ArrayList<>();
//		UserProgramPostReq resp;
//		for(User_Program up : list) {
//			resp = new UserProgramPostReq();
//			resp.setUser_id(up.getUser().getId());
//			resp.setProgram_id(up.getProgram().getId());
//			copy.add(resp);
//		}
//		return copy;
//	}

}
