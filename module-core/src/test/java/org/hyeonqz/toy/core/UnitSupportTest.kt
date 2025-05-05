package org.hyeonqz.toy.core

import io.mockk.clearAllMocks
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UnitSupportTest {

    @BeforeEach
    fun setUp() {
        // 각 테스트 전에 모킹 초기화
        clearAllMocks()
    }
}