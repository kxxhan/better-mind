package com.ssafy.api.request;

import java.util.Date;

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
	private Date created_at;
}
