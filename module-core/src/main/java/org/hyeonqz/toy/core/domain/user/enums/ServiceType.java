package org.hyeonqz.toy.core.domain.user.enums;

import lombok.Getter;

@Getter
public enum ServiceType {
	A("전체"),
	P("연금복권"),
	R("일반복권")
	;

	private String description;

	ServiceType (String description) {
		this.description = description;
	}
}
