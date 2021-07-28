package com.ssafy.api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;

public interface CommunityService {

	Community_Article createArticle(CommunityPostReq communityPostReq);

	long getAllArticleCount();

	Community_Article getOneArticle(Long id);

	Community_Article updateArticle(Long id, CommunityPostReq communityPostReq);

	void deleteArticle(Long id);

	List<Community_Article> getAllArticle(Pageable pageable);

	Community_Article createComment(Long id, CommentPostReq comment);

	Community_Comment updateComment(Long aId, Long cId, CommentPostReq comment);

	void deleteComment(Long aId, Long cId);

}
