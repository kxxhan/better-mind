package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ReviewPostReq")
public class ReviewPostReq {

	private String userid;
	private String content;
}
