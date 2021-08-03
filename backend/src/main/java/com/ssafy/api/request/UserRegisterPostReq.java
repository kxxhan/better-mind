package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 회원가입 API ([POST] /api/v1/users) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@ApiModelProperty(name = "유저 ID", example = "ssafy_web")
	private String id;
	@ApiModelProperty(name = "유저 Password", example = "your_password")
	private String password;
	@ApiModelProperty(name = "유저 email", example = "your_email")
	private String email;
//	@ApiModelProperty(name = "유저 주소", example = "경기도 용인시 처인구 남동")
//	private String address;
	@ApiModelProperty(name = "유저 전화번호", example = "010-2222-1111")
	private String phone;
	@ApiModelProperty(name = "유저 이름", example = "홍길동")
	private String name;
	@ApiModelProperty(name = "설명", example = "자기 소개")
	private String description;
	@ApiModelProperty(name = "분류", example = "증상이나 감정")
	private String category;
	@ApiModelProperty(name = "권한", example = "0->일반 사용자 , 1->전문가, 2->관리자")
	private String role;	
	@ApiModelProperty(name = "자격번호", example = "000000000")
	private String certificate;
	
	
}
