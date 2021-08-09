package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserProgramPostReq;
import com.ssafy.api.service.UserProgramService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.User_Program;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "유저프로그램 api", tags = { "UserProgram" })
@RestController
@RequestMapping("/api/v1/userprogram")
public class UserProgramController {

	@Autowired
	private UserProgramService service;
	
	@PostMapping()
	@ApiOperation(value = "유저프로그램 신청", notes = "<strong>유저프로그램 신청</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createUserProgram(@RequestBody UserProgramPostReq userprogramPostReq) {
		User_Program userprogram = service.createUserProgram(userprogramPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/{userprogramId}")
	@ApiOperation(value = "유저프로그램 신청 취소", notes = "<strong>유저프로그램 신청 취소</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> deleteUserProgram(@PathVariable(name = "userprogramId") Long id) {
		service.deleteUserProgram(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
