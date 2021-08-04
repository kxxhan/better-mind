package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("AnswerPostReq")
public class AnswerPostReq {
	private String userId;
	private String content;
	private Long id;
}
