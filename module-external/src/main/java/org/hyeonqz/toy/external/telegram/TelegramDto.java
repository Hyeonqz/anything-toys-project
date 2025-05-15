package org.hyeonqz.toy.external.telegram;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TelegramDto {

	private MessageType type;
	private String target;
	private String time;
	private String cause;
	private String detail;

	public String createMessage() {
		return String.format(
			"%s\nTarget: %s\nTime: %s\nCause: %s\nDetail: %s",
			this.type.getText(),
			this.target,
			this.time,
			this.cause,
			this.detail
		);
	}

	@Builder
	public TelegramDto(MessageType type, String target, String time, String cause, String detail) {
		this.type = type;
		this.target = target;
		this.time = time;
		this.cause = cause;
		this.detail = detail;
	}
}
