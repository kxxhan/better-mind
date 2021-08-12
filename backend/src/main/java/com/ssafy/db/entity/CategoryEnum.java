package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoryEnum {
	취업진로, 직장, 연애, 성추행, 대인관계, 외모, 가족, 학업, 금전, 이별이혼, 육아, 중독, 건강, 성격;
	
	@JsonCreator
    public static CategoryEnum from(String s) {
        return CategoryEnum.valueOf(s);
    }
}
