package org.hyeonqz.toy.core.domain.lotto.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="lotto_round")
@Entity
public class LottoRound {

	@Comment("1은 일반복권, 2는 연금복권")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Comment("로또 회차")
	@Column(nullable = false, length = 20, name = "ROUND_NUMBER")
	private int roundNumber;

	@Comment("로또 결과 날짜")
	@Column(nullable = false, name = "PRE_DATE")
	private String preDate;

	@Comment("회차 변경 날짜")
	@Column(name="UPDATE_DT")
	private LocalDateTime updateTime;

	@Builder
	public LottoRound (int roundNumber, LocalDateTime updateTime, String preDate) {
		this.roundNumber = roundNumber;
		this.preDate = preDate;
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
