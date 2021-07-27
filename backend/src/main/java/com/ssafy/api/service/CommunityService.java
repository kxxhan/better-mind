package com.ssafy.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.entity.Community_Article;

public interface CommunityService {

	Community_Article createArticle(CommunityPostReq communityPostReq);

	long getAllArticleCount();

	Community_Article getOneArticle(Long id);

	Community_Article putOneArticle(Long id, CommunityPostReq communityPostReq);

	void deleteOneArticle(Long id);

	List<Community_Article> getAllArticle(Pageable pageable);

}
