package com.ssafy.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.AnswerPostReq;
import com.ssafy.api.request.QuestionPostReq;
import com.ssafy.api.response.PostitGetRes;
import com.ssafy.db.entity.Postit_Answer;
import com.ssafy.db.entity.Postit_Question;

public interface PostitService {

	Postit_Question createQuestion(QuestionPostReq questionPostReq) throws IllegalStateException, IOException;
	
	PostitGetRes getOnePostit(Long id);
	
	Postit_Question updateQuestion(Long id, QuestionPostReq questionPostReq);
	
	void deleteQuestion(Long id);
	
	Postit_Answer createAnswer(Long id, AnswerPostReq answer);
	
	Postit_Answer updateAnswer(Long id, Long aId, AnswerPostReq answer);
	
	void deleteAnswer(Long qId, Long aId);
	
	long getAllQuestionCount();
	
	List<QuestionPostReq> getAllQuestion(Pageable pageable);
}
