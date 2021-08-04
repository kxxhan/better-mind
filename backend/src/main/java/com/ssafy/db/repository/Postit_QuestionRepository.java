package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Postit_Question;

@Repository
public interface Postit_QuestionRepository extends JpaRepository<Postit_Question, Long>{

}
