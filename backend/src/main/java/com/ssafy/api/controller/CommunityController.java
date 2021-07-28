package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.api.service.CommunityService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "커뮤니티 게시판", tags = { "Article" })
@RestController
@RequestMapping("/api/v1/article")
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	@PostMapping()
	@ApiOperation(value = "글 작성", notes = "<strong>글 작성</strong>") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<BaseResponseBody> createArticle(@RequestBody CommunityPostReq communityPostReq){
		
		Community_Article article = service.createArticle(communityPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/allCount")
	@ApiOperation(value = "글 전체 카운트", notes = "<strong>Page 구성</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Long> getAllArticleCount(){
		
		long size = service.getAllArticleCount();
		return ResponseEntity.status(200).body(size);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "글 전체 목록", notes = "<strong>page랑 한페이지에  들어갈 size</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<List<Community_Article>> getAllArticle(Pageable pageable){
		
		List<Community_Article> articleList = service.getAllArticle(pageable);
		return ResponseEntity.status(200).body(articleList);
	}
	
	@GetMapping("/{articleId}")
	@ApiOperation(value = "글 내용", notes = "<strong>글 내용</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Community_Article> getOneArticle(@PathVariable(name="articleId") Long id){
		
		Community_Article article = service.getOneArticle(id);
		return ResponseEntity.status(200).body(article);
	}
	
	@PutMapping("/{articleId}")
	@ApiOperation(value = "글 수정", notes = "<strong>글 수정</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<BaseResponseBody> putOneArticle(@PathVariable(name="articleId") Long id,@RequestBody CommunityPostReq communityPostReq){
		
		Community_Article result = service.updateArticle(id,communityPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/{articleId}")
	@ApiOperation(value = "글 삭제", notes = "<strong>글 삭제</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<BaseResponseBody> deleteOneArticle(@PathVariable(name="articleId") Long id){
		
		service.deleteArticle(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PostMapping("/{articleId}")
	@ApiOperation(value = "댓글 작성", notes = "<strong>댓글 내용</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Community_Article> createComment(@PathVariable(name="articleId") Long id,@RequestBody CommentPostReq comment){
		
		Community_Article community_Article = service.createComment(id,comment);
		return ResponseEntity.status(200).body(community_Article);
	}
	@PutMapping("/{articleId}/{commentId}")
	@ApiOperation(value = "댓글 수정", notes = "<strong>댓글 내용</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Community_Comment> updateComment(@PathVariable(name="articleId") Long aId,@PathVariable(name="commentId") Long cId,@RequestBody CommentPostReq comment){
		
		Community_Comment community_comment = service.updateComment(aId,cId,comment);
		return ResponseEntity.status(200).body(community_comment);
	}
	@DeleteMapping("/{articleId}/{commentId}")
	@ApiOperation(value = "댓글 삭제", notes = "<strong>댓글 내용</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<BaseResponseBody> deleteComment(@PathVariable(name="articleId") Long aId,@PathVariable(name="commentId") Long cId){
		
		service.deleteComment(aId,cId);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
