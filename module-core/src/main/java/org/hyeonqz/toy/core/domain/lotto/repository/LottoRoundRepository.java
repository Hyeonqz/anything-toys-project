package org.hyeonqz.toy.core.domain.lotto.repository;

import org.hyeonqz.toy.core.domain.lotto.model.LottoRound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoRoundRepository extends JpaRepository<LottoRound, Long> {
}
