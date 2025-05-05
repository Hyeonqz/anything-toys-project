package org.hyeonqz.toy.core.application.lotto.service

import org.hyeonqz.toy.core.domain.lotto.model.Lotto
import org.hyeonqz.toy.core.domain.lotto.model.LottoRound
import org.hyeonqz.toy.core.domain.lotto.model.enums.LottoType
import org.hyeonqz.toy.core.domain.lotto.repository.LottoRepository
import org.hyeonqz.toy.core.domain.lotto.repository.LottoRoundRepository
import org.hyeonqz.toy.core.domain.lotto.util.LottoUtils
import org.hyeonqz.toy.core.domain.user.User
import org.hyeonqz.toy.core.domain.user.enums.ServiceStatus
import org.hyeonqz.toy.core.domain.user.enums.ServiceType
import org.hyeonqz.toy.core.domain.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDateTime

@Transactional
@Service
class CreateLottoService(
    private val lottoRepository: LottoRepository,
    private val userRepository: UserRepository,
    private val roundRepository: LottoRoundRepository
) {

    fun createLotto(): String {
        val lottoRound = this.getLottoRound()
        val generalLottoNumber = lottoRound[0].roundNumber
        val pensionLottoNumber = lottoRound[1].roundNumber

        val allUsers = this.getAllUsers()

        val pensionUsers = this.getPensionUsers()

        val generalUsers = this.getGeneralUsers()

        val lottoList = mutableListOf<Lotto>()
        for (user in allUsers) {
            val regularLotto = Lotto(
                LottoType.REGULAR,
                LottoUtils.createGeneralLotto(),
                generalLottoNumber,
                BigDecimal.valueOf(5000),
                user.name,
                user,
                LocalDateTime.now()
            )
            val pensionLotto = Lotto(
                LottoType.PENSION,
                LottoUtils.createPensionLotto(),
                pensionLottoNumber,
                BigDecimal.valueOf(5000),
                user.name,
                user,
                LocalDateTime.now()
            )
            lottoList.add(regularLotto)
            lottoList.add(pensionLotto)
        }

        for (user in pensionUsers) {
            val pensionLotto = Lotto(
                LottoType.PENSION, LottoUtils.createPensionLotto(),
                pensionLottoNumber,
                BigDecimal.valueOf(5000),
                user.name,
                user,
                LocalDateTime.now()
            )
            lottoList.add(pensionLotto)
        }

        for (user in generalUsers) {
            val regularLotto = Lotto(
                LottoType.REGULAR,
                LottoUtils.createGeneralLotto(),
                generalLottoNumber,
                BigDecimal.valueOf(5000),
                user.name,
                user,
                LocalDateTime.now()
            )
            lottoList.add(regularLotto)
        }

        lottoRepository.saveAll(lottoList);

        return "Success"
    }

    private fun getLottoRound(): List<LottoRound> = roundRepository.findAll()

    private fun getGeneralUsers(): List<User> = userRepository.findUsersByServiceStatusAndServiceType(
        ServiceStatus.ACTIVE, ServiceType.R
    )

    private fun getAllUsers(): List<User> = userRepository.findUsersByServiceStatusAndServiceType(
        ServiceStatus.ACTIVE, ServiceType.A
    )

    private fun getPensionUsers(): List<User> = userRepository.findUsersByServiceStatusAndServiceType(
        ServiceStatus.ACTIVE, ServiceType.P
    )

}