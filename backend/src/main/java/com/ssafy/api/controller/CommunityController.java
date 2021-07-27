package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.api.service.CommunityService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.BaseEntity;

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
		
		CommunityPostReq article = service.createArticle(communityPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/allCount")
	@ApiOperation(value = "글 전체 카운트", notes = "<strong>Page 구성</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Integer> getAllArticleCount(){
		
		int size = service.getAllArticleCount();
		return ResponseEntity.status(200).body(size);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "글 전체 목록", notes = "<strong>page랑 한페이지에  들어갈 size</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<List<CommunityPostReq>> getAllArticle(@RequestParam int page,@RequestParam int size){
		
		List<CommunityPostReq> articleList = service.getAllArticle(page,size);
		return ResponseEntity.status(200).body(articleList);
	}
	
	@GetMapping("/{articleId}")
	@ApiOperation(value = "글 내용", notes = "<strong>글 내용</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<CommunityPostReq> getOneArticle(@PathVariable(name="articleId") int id){
		
		CommunityPostReq article = service.getOneArticle(id);
		return ResponseEntity.status(200).body(article);
	}
	
	@PutMapping("/{articleId}")
	@ApiOperation(value = "글 수정", notes = "<strong>글 수정</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<BaseResponseBody> putOneArticle(@PathVariable(name="articleId") int id){
		
		int result = service.putOneArticle(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/{articleId}")
	@ApiOperation(value = "글 삭제", notes = "<strong>글 삭제</strong>") 
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
		@ApiResponse(code = 401, message = "토큰 인증 실패"),
		@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<BaseResponseBody> deleteOneArticle(@PathVariable(name="articleId") int id){
		
		int result = service.deleteOneArticle(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
}
