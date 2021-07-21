package com.ssafy.api.response;

import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 본인 정보 조회 API ([GET] /api/v1/users/me) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserResponse")
public class UserRes{
	@ApiModelProperty(name="직책")
	private String position;
	@ApiModelProperty(name="소속")
	private String department;
	@ApiModelProperty(name="이름")
	private String name;
	@ApiModelProperty(name="User ID")
	private String userId;
	@ApiModelProperty(name="허가")
	private String role;
	
	public static UserRes of(User user) {
		UserRes res = new UserRes();
		res.setUserId(user.getUserId());
		res.setDepartment(user.getDepartment());
		res.setName(user.getName());
		res.setPosition(user.getPosition());
		res.setRole(user.getRole());
		return res;
	}
}
