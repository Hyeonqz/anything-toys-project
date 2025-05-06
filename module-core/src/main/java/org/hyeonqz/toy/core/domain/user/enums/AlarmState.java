package org.hyeonqz.toy.core.domain.user.enums;

import lombok.Getter;

@Getter
public enum AlarmState {
	S("Success"),
	F("Fail")
	;

	private String description;

	AlarmState (String description) {
		this.description = description;
	}
}
