package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.repository.Community_ArticleRepository;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	Community_ArticleRepository repository;
	
//	@Autowired
//	CommunityArticleRepositorySupport repositorySupport;

	@Override
	public CommunityPostReq createArticle(CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityPostReq> getAllArticle(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllArticleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CommunityPostReq getOneArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int putOneArticle(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneArticle(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
