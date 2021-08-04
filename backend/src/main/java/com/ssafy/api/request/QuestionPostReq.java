package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("QuestionPostRequest")
public class QuestionPostReq {
	@ApiModelProperty(name="질문 번호 ID", example = "Long")
	private Long id;
	@ApiModelProperty(name="질문 내용")
	private String content;

}
