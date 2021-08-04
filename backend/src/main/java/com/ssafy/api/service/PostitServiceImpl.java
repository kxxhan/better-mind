package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.repository.Postit_AnswerRepository;
import com.ssafy.db.repository.Postit_QuestionRepository;
import com.ssafy.db.repository.UserRepository;

@Service("PostitService")
public class PostitServiceImpl implements PostitService {

	@Autowired
	Postit_QuestionRepository questionRepository;
	
	@Autowired
	Postit_AnswerRepository answerRepository;
	
	@Autowired
	UserRepository userRepository;
	
}
