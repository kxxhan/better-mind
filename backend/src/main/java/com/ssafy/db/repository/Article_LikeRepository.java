package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Article_Like;

@Repository
public interface Article_LikeRepository extends JpaRepository<Article_Like, Long> {
	Optional<Article_Like> findByUser_idAndArticle_id(Long user_id,Long article_id);
}
