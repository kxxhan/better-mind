package com.ssafy.api.response;

import java.util.Date;
import java.util.List;

import com.ssafy.api.request.AnswerPostReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("PostitGetResponse")
public class PostitGetRes {

	@ApiModelProperty(name="질문 번호 ID", example = "Long")
	private Long id;
//	@ApiModelProperty(name="유저 ID", example = "ssafy_web")
//	private String userId;
	@ApiModelProperty(name="질문 내용")
	private String content;
	@ApiModelProperty(name="답변")
	private List<AnswerPostReq> answer;
	@ApiModelProperty(name="작성시간")
	private Date created_at;
}
