package org.hyeonqz.toy.core.domain.lotto.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Random

class LottoUtilsTest {

    @Test
    fun createGeneralLotto() {
        val map = mutableMapOf<String, List<Int>>()

        for (i in 1..5) {
            val numbers = mutableSetOf<Int>()
            val random = Random()

            while (numbers.size < 6) {
                val number = random.nextInt(45 - 1 + 1) + 1
                numbers.add(number)
            }
            map["$i"] = numbers.sorted()
        }

        println(map)
        Assertions.assertThat(map).hasSize(5)
    }

    @Test
    fun createPensionLotto() {
        val map = mutableMapOf<String, List<Int>>()

        for (i in 1..5) {
            val random = Random()

            val groupNumber = random.nextInt(5 - 1 + 1) + 1

            // 0~9 숫자 5개 생성
            val numbers = mutableSetOf<Int>()
            while (numbers.size < 6) {
                val number = random.nextInt(9 - 0 + 1) + 0
                numbers.add(number)
            }
            map["pension$i"] = listOf(groupNumber) + numbers.sorted()
        }

        println(map)
    }

}