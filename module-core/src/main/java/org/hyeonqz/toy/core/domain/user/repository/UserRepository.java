package org.hyeonqz.toy.core.domain.user.repository;

import java.util.List;

import org.hyeonqz.toy.core.domain.user.User;
import org.hyeonqz.toy.core.domain.user.enums.ServiceStatus;
import org.hyeonqz.toy.core.domain.user.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findUsersByServiceStatusAndServiceType(ServiceStatus serviceStatus, ServiceType serviceType);
}
