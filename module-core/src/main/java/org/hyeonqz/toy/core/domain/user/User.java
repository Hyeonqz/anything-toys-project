package org.hyeonqz.toy.core.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Comment;
import org.hyeonqz.toy.core.domain.lotto.model.Lotto;
import org.hyeonqz.toy.core.domain.user.enums.ServiceStatus;
import org.hyeonqz.toy.core.domain.user.enums.ServiceType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Comment("User 고유 ID")
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID uniqueId;

	@Comment("서비스 제공 상태")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "varchar(10)")
	private ServiceStatus serviceStatus;

	@Comment("로또 제공 상태")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "char(1)")
	private ServiceType serviceType;

	@Comment("User 이름")
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String name;

	@Comment("User 이메일")
	@Column(nullable = false)
	private String email;

	@Comment("전화번호")
	@Column(nullable = false)
	private String phoneNumber;

	@Comment("주소")
	@Column(nullable = false)
	private String address;

	@Comment("상세주소")
	@Column(nullable = false)
	private String addressDetail;

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Lotto> lotto = new ArrayList<>();

	@Builder
	public User (UUID uniqueId, ServiceStatus serviceStatus, ServiceType serviceType, String name, String email,
		String phoneNumber, String address, String addressDetail, List<Lotto> lotto) {
		this.uniqueId = uniqueId;
		this.serviceStatus = serviceStatus;
		this.serviceType = serviceType;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.lotto = lotto;
	}

	public Long getId () {
		return id;
	}

	public UUID getUniqueId () {
		return uniqueId;
	}

	public ServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	public ServiceType getServiceType () {
		return serviceType;
	}

	public String getName () {
		return name;
	}

	public String getEmail () {
		return email;
	}

	public String getPhoneNumber () {
		return phoneNumber;
	}

	public String getAddress () {
		return address;
	}

	public String getAddressDetail () {
		return addressDetail;
	}

	public List<Lotto> getLotto () {
		return lotto;
	}

}