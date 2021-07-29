package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.api.request.ReviewPostReq;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.Program_Review;
import com.ssafy.db.repository.ProgramRepository;
import com.ssafy.db.repository.Program_FileRepository;
import com.ssafy.db.repository.Program_ReviewRepository;
import com.ssafy.db.repository.UserRepository;

@Service("ProgramService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	ProgramRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Program_ReviewRepository reviewRepository;
	
	@Override
	public Program createProgram(ProgramPostReq programPostReq) {
		Program program = new Program();
		program.setUser(userRepository.findByUserId(programPostReq.getUserId()).get());
		program.setName(programPostReq.getName());
		program.setReport(programPostReq.getReport());
		program.setPrice(programPostReq.getPrice());
		program.setCount(programPostReq.getCount());
		program.setTime(programPostReq.getTime());
		return repository.save(program);
	}
	
	@Override
	public List<Program> getAllProgram(Pageable pageable) {
		return repository.findAll();
	}
	
	@Override
	public long getAllProgramCount() {
		return repository.count();
	}
	
	@Override
	public Program getOneProgram(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Program updateProgram(Long id, ProgramPostReq programPostReq) {
		Program program = repository.getOne(id);
		program.setName(programPostReq.getName());
		program.setReport(programPostReq.getReport());
		program.setPrice(programPostReq.getPrice());
		program.setCount(programPostReq.getCount());
		program.setTime(programPostReq.getTime());
		return repository.save(program);
	}
	
	@Override
	public void deleteProgram(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Program_Review createReview(Long id, ReviewPostReq review) {
//		Program_Review review = new Program
		return null;
	}

	@Override
	public Program_Review updateReview(Long id, Long rId, ReviewPostReq review) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReview(Long pId, Long rId) {
		// TODO Auto-generated method stub
		
	}
	
}
