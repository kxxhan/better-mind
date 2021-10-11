package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Community_Article;

@Repository
public interface Community_ArticleRepository extends JpaRepository<Community_Article, Long> {
	
}
