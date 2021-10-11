package com.ssafy.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.api.request.ReviewPostReq;
import com.ssafy.api.response.ProgramGetRes;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.Program_Review;

public interface ProgramService {

	Program createProgram(ProgramPostReq programPostReq, MultipartFile[] files) throws IllegalStateException, IOException;
	
	long getAllProgramCount();
	
	ProgramGetRes getOneProgram(Long id);
	
	Program updateProgram(Long id, ProgramPostReq programPostReq);
	
	void deleteProgram(Long id);

	List<ProgramPostReq> getAllProgram(Pageable pageable);
	
	Program_Review createReview(Long id, ReviewPostReq review);
	
	Program_Review updateReview(Long id, Long rId, ReviewPostReq review);
	
	void deleteReview(Long pId, Long rId);
	
	ProgramGetRes getOneProgramUser(Long id); // 프로그램 신청자들

	Program findByProgramId(Long program_id);
}
