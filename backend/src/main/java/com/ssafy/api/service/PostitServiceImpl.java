package com.ssafy.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.AnswerPostReq;
import com.ssafy.api.request.QuestionPostReq;
import com.ssafy.api.response.PostitGetRes;
import com.ssafy.db.entity.Postit_Answer;
import com.ssafy.db.entity.Postit_Question;
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

	@Override
	@Transactional
	public Postit_Question createQuestion(QuestionPostReq questionPostReq) throws IllegalStateException, IOException{
		Postit_Question question = new Postit_Question();
		question.setContent(questionPostReq.getContent());
		question.setCreated_at(question.getCreated_at());
		question = questionRepository.save(question);
		return question;
	}

	@Override
	public PostitGetRes getOnePostit(Long id) {
		Postit_Question question = questionRepository.findById(id).get();
		PostitGetRes p = new PostitGetRes();
		p.setId(question.getId());
		p.setContent(question.getContent());
		p.setCreated_at(question.getCreated_at());
		List<Postit_Answer> alist = answerRepository.findByPostitquestion_id(question.getId()).get();
		if(alist != null) {
			List<AnswerPostReq> answers = new ArrayList<>();
			for(Postit_Answer k : alist) {
				AnswerPostReq a = new AnswerPostReq();
				a.setUserId(k.getUser().getUserid());
				a.setContent(k.getContent());
				a.setCreated_at(k.getCreated_at());
				a.setId(k.getId());
				answers.add(a);
			}
			p.setAnswer(answers);
		}
		return p;
	}

	@Override
	public Postit_Question updateQuestion(Long id, QuestionPostReq questionPostReq) {
		Postit_Question question = questionRepository.getOne(id);
		question.setContent(questionPostReq.getContent());
		question.setUpdated_at(new Date());
		return questionRepository.save(question);
	}

	@Override
	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}

	@Override
	public Postit_Answer createAnswer(Long id, AnswerPostReq answer) {
		Postit_Answer ans = new Postit_Answer();
		ans.setUser(userRepository.findByUserid(answer.getUserId()).get());
		ans.setContent(answer.getContent());
		Postit_Question que = questionRepository.getOne(id);
		ans.setPostitquestion(que);
		return answerRepository.save(ans);
	}

	@Override
	public Postit_Answer updateAnswer(Long id, Long aId, AnswerPostReq answer) {
		Postit_Answer ans = answerRepository.getOne(aId);
		ans.setContent(answer.getContent());
		ans.setUpdated_at(new Date());
		return answerRepository.save(ans);
	}

	@Override
	public void deleteAnswer(Long qId, Long aId) {
		answerRepository.deleteById(aId);
	}

	@Override
	public long getAllQuestionCount() {
		return questionRepository.count();
	}

	@Override
	public List<QuestionPostReq> getAllQuestion(Pageable pageable) {
		List<Postit_Question> list = questionRepository.findAll(pageable).getContent();
		List<QuestionPostReq> copy = new ArrayList<>();
		QuestionPostReq resp;
		for(Postit_Question q : list) {
			resp = new QuestionPostReq();
			resp.setId(q.getId());
			resp.setContent(q.getContent());
			resp.setCreated_at(q.getCreated_at());
			copy.add(resp);
		}
		return copy;
	}
	
}
