package org.hyeonqz.toy.core.domain.lotto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hyeonqz.toy.core.domain.lotto.model.enums.LottoType;
import org.hyeonqz.toy.core.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name= "lotto")
@Entity
public class Lotto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Comment("로또 타입")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private LottoType type;

	@Comment("로또 추천 번호")
	@JdbcTypeCode(SqlTypes.JSON)
	@Column
	private Map<String, List<Integer>> recommendNumbers;

	@Comment("로또 회차")
	@Column(nullable = false)
	private int roundNumber;

	@Comment("로또 구매시 가격")
	@Column(nullable = false)
	private BigDecimal price;

	@Comment("로또 구매자")
	@Column(nullable = false)
	private String recipient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@Builder
	public Lotto (LottoType type, Map<String, List<Integer>> recommendNumbers, int roundNumber, BigDecimal price, String recipient,
		User user, LocalDateTime createdAt) {
		this.type = type;
		this.recommendNumbers = recommendNumbers;
		this.roundNumber = roundNumber;
		this.price = price;
		this.recipient = recipient;
		this.user = user;
		this.createdAt = createdAt;
	}

}
