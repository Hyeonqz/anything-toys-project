package org.hyeonqz.toy.core.domain.user;

import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.hyeonqz.toy.core.domain.user.enums.ServiceStatus;
import org.hyeonqz.toy.core.domain.user.enums.ServiceType;
import org.hyeonqz.toy.core.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("local")
@SpringBootTest
class UserTest {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Test
	@DisplayName("User를 생성한다")
	void UserCreateTest() {
	    // given & when
		User user1 = User.builder()
			.uniqueId(UUID.randomUUID())
			.serviceStatus(ServiceStatus.ACTIVE)
			.serviceType(ServiceType.A)
			.name("test-1")
			.email("test@naver.com")
			.phoneNumber("01012345678")
			.address("서울특별시 중구")
			.addressDetail("을지로 3가")
			.lotto(List.of())
			.build();

		User user2 = User.builder()
			.uniqueId(UUID.randomUUID())
			.serviceStatus(ServiceStatus.ACTIVE)
			.serviceType(ServiceType.P)
			.name("test-3")
			.email("test@naver.com")
			.phoneNumber("01012345678")
			.address("서울특별시 중구")
			.addressDetail("을지로 4가")
			.lotto(List.of())
			.build();

		User user3 = User.builder()
			.uniqueId(UUID.randomUUID())
			.serviceStatus(ServiceStatus.ACTIVE)
			.serviceType(ServiceType.R)
			.name("test-3")
			.email("test3@naver.com")
			.phoneNumber("01012345678")
			.address("서울특별시 중구")
			.addressDetail("을지로 5가")
			.lotto(List.of())
			.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

	    // then
		Assertions.assertThat(user1).isNotNull();
		Assertions.assertThat(user2).isNotNull();
		Assertions.assertThat(user3).isNotNull();
	}
}