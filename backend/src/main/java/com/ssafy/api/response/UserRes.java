package com.ssafy.api.response;

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
	@ApiModelProperty(name = "유저 pk", example = "Long")
	private Long id;
	@ApiModelProperty(name = "유저 ID", example = "String")
	private String userid;
	@ApiModelProperty(name = "유저 email")
	private String email;
//	@ApiModelProperty(name = "유저 주소")
//	private String address;
	@ApiModelProperty(name = "유저 전화번호")
	private String phone;
	@ApiModelProperty(name = "유저 이름")
	private String name;
	@ApiModelProperty(name = "유저 카테고리")
	private String category;
	@ApiModelProperty(name = "유저 설명")
	private String description;
	@ApiModelProperty(name = "권한")
	private String role;
	
	public static UserRes of(User user) {
		UserRes res = new UserRes();
		res.setId(user.getId());
		res.setUserid(user.getUserid());
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setPhone(user.getPhone());
		res.setCategory(user.getCategory().toString());
		res.setDescription(user.getDescription());
		res.setRole(user.getRole());
		return res;
	}
}
