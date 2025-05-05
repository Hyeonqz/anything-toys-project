package org.hyeonqz.toy.core.domain.lotto.repository;

import org.hyeonqz.toy.core.domain.lotto.model.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoRepository extends JpaRepository<Lotto, Long> {
}
