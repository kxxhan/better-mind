package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Postit_Answer;

public interface Postit_AnswerRepository extends JpaRepository<Postit_Answer, Long>{
	Optional<List<Postit_Answer>> findByPostitquestion_id(Long postit_question_id);
}
