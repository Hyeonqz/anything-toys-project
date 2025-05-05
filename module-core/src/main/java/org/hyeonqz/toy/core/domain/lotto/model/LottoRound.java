package org.hyeonqz.toy.core.domain.lotto.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class LottoRound {

	@Comment("1은 일반복권, 2는 연금복권")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Comment("로또 회차")
	private int roundNumber;

	@Comment("회차 변경 날짜")
	private LocalDateTime updateTime;

	@Builder
	public LottoRound (int roundNumber, LocalDateTime updateTime) {
		this.roundNumber = roundNumber;
		this.updateTime = updateTime;
	}

	public void plusRound() {
		this.roundNumber += 1;
	}

	public Long getId () {
		return id;
	}

	public int getRoundNumber () {
		return roundNumber;
	}

	public LocalDateTime getUpdateTime () {
		return updateTime;
	}

}
