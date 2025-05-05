package org.hyeonqz.toy.core.domain.lotto.model.enums;

import lombok.Getter;

@Getter
public enum LottoType {
	REGULAR("일반복권"),
	PENSION("연금복권")
	;

	private String description;

	LottoType (String description) {
		this.description = description;
	}
}
