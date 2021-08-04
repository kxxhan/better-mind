package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CommentPostReq")
public class CommentPostReq {
	private String userId;
	private String content;
	private Long id;
}
