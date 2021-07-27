package com.ssafy.api.service;

import java.util.List;

import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.entity.Community_Article;

public interface CommunityService {

	Community_Article createArticle(CommunityPostReq communityPostReq);

	List<CommunityPostReq> getAllArticle(int page, int size);

	int getAllArticleCount();

}
