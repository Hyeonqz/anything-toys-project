package org.hyeonqz.toy.core.domain.user.enums;

import lombok.Getter;

@Getter
public enum ServiceStatus {
	ACTIVE("활성화"),
	INACTIVE("비활성화"),
	DELETED("삭제 처리")
	;

	private String description;

	ServiceStatus (String description) {
		this.description = description;
	}
}
