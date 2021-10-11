package com.ssafy.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.AnswerPostReq;
import com.ssafy.api.request.QuestionPostReq;
import com.ssafy.api.response.PostitGetRes;
import com.ssafy.api.service.PostitService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Postit_Answer;
import com.ssafy.db.entity.Postit_Question;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "포스트잇 api", tags = { "Postit" })
@RestController
@RequestMapping("/api/v1/postit")
public class PostitController {

	@Autowired
	private PostitService service;
	
	@PostMapping()
	@ApiOperation(value = "질문 등록", notes = "<strong>질문 등록</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createQuestion(@RequestBody QuestionPostReq questionPostReq) {
		try {
			Postit_Question question = service.createQuestion(questionPostReq);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/{questionId}")
	@ApiOperation(value = "포스트잇 메인", notes = "<strong>하나의 포스트잇 보여줌</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<PostitGetRes> getOnePostit(@PathVariable(name = "questionId")Long id) {
		PostitGetRes postit = service.getOnePostit(id);
		return ResponseEntity.status(200).body(postit);
	}
	
	@PutMapping("/{questionId}")
	@ApiOperation(value = "질문 수정", notes = "<strong>질문 수정</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> putOneQuestion(@PathVariable(name = "questionId")Long id, 
			@RequestBody QuestionPostReq questionPostReq) {
		Postit_Question result = service.updateQuestion(id, questionPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/{questionId}")
	@ApiOperation(value = "질문 삭제", notes = "<strong>질문 삭제</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> deleteOneQuestion(@PathVariable(name = "questionId")Long id) {
		service.deleteQuestion(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	// 답변
	@PostMapping("/{questionId}")
	@ApiOperation(value = "답변 작성", notes = "<strong>답변 내용</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createAnswer(@PathVariable(name = "questionId")Long id, @RequestBody AnswerPostReq answer) {
		Postit_Answer postit_answer = service.createAnswer(id, answer);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PutMapping("{questionId}/{answerId}")
	@ApiOperation(value = "답변 수정", notes = "<strong>답변 수정</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<Postit_Answer> updateAnswer(@PathVariable(name = "questionId")Long qid,
			@PathVariable(name = "answerId")Long aId, @RequestBody AnswerPostReq answer) {
		Postit_Answer postit_answer = service.updateAnswer(qid, aId, answer);
		return ResponseEntity.status(200).body(postit_answer);
	}
	
	@DeleteMapping("{questionId}/{answerId}")
	@ApiOperation(value = "답변 삭제", notes = "<strong>답변 삭제</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> deleteAnswer(@PathVariable(name = "questionId")Long qId,
			@PathVariable(name = "answerId")Long aId) {
		service.deleteAnswer(qId, aId);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/allCount")
	@ApiOperation(value = "질문 전체 카운트", notes = "<strong>Page 구성</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<Long> getAllQuestionCount() {
		long size = service.getAllQuestionCount();
		return ResponseEntity.status(200).body(size);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "질문 전체 목록", notes = "<strong>page랑 한페이지에  들어갈 size</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<List<QuestionPostReq>> getAllQuestion(Pageable pageable) {
		List<QuestionPostReq> questionList = service.getAllQuestion((Pageable) pageable);
		return ResponseEntity.status(200).body(questionList);
	}
	
}
