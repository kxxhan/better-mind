package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Expert;

public interface ExpertRepository extends JpaRepository<Expert, Long> {

}
