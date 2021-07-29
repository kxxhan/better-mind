package com.ssafy.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.Program_Review;

public interface ProgramService {

	Program createProgram(ProgramPostReq programPostReq);
	
	long getAllProgramCount();
	
	Program getOneProgram(Long id);
	
	Program updateProgram(Long id, ProgramPostReq programPostReq);
	
	void deleteProgram(Long id);

	List<Program> getAllProgram(Pageable pageable);
	
//	List<Program_Review> createReview(Long id, ReviewPostReq review);
//	
//	Program_Review createReview(Long id, ReviewPostReq review);
//	
//	Program_Review updateReview(Long id, Long rId, ReviewPostReq review);
//	
//	void deleteReview(Long pId, Long rId);
}
