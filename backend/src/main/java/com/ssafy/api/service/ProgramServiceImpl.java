package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.repository.ProgramRepository;
import com.ssafy.db.repository.Program_FileRepository;
import com.ssafy.db.repository.Program_ReviewRepository;

@Service("ProgramService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	ProgramRepository repository;
	
	@Autowired
	Program_FileRepository fileRepository;
	
//	@Autowired
//	Program_ReviewRepository reviewRepository;
	
	@Override
	public Program createProgram(ProgramPostReq programPostReq) {
		
	}
}
