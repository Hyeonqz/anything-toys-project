package org.hyeonqz.toy.core.application.lotto.service

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test

@ActiveProfiles("local")
@SpringBootTest
class CreateLottoServiceTest(
    @Autowired val service: CreateLottoService
) {

    @Test
    fun createLottoService() {
        service.createLotto();
    }
}