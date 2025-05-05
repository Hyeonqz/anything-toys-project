package org.hyeonqz.toy.core.domain.lotto.util

import java.util.Random

object LottoUtils {
    private const val GENERAL_MIN_NUMBER = 1
    private const val GENERAL_MAX_NUMBER = 45

    private const val NUMBER_COUNT = 6
    private const val SET_COUNT = 5

    private const val PENSION_GROUP_MIN = 1
    private const val PENSION_GROUP_MAX = 5
    private const val PENSION_MIN_NUMBER = 0
    private const val PENSION_MAX_NUMBER = 9

    /** 랜덤 일반복권을 생성한다. */
    fun createGeneralLotto(): Map<String, List<Int>> {
        val map = mutableMapOf<String, List<Int>>()

        for (i in 1..SET_COUNT) {
            val numbers = this.generateSingleSet()
            map["general$i"] = numbers
        }

        return map
    }

    /** 랜덤 연금복권을 생성한다. */
    fun createPensionLotto(): Map<String, List<Int>> {
        val map = mutableMapOf<String, List<Int>>()

        for (i in 1..SET_COUNT) {
            val numbers = this.generatePensionNumbers()
            map["pension$i"] = numbers
        }

        return map
    }

    private fun generateSingleSet(): List<Int> {
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (numbers.size < NUMBER_COUNT) {
            val number = random.nextInt(GENERAL_MAX_NUMBER - GENERAL_MIN_NUMBER + 1) + GENERAL_MIN_NUMBER
            numbers.add(number)
        }

        return numbers.sorted()
    }

    private fun generatePensionNumbers(): List<Int> {
        val random = Random()

        val groupNumber = random.nextInt(PENSION_GROUP_MAX - PENSION_GROUP_MIN + 1) + PENSION_GROUP_MIN

        // 0~9 숫자 5개 생성
        val numbers = mutableSetOf<Int>()
        while (numbers.size < NUMBER_COUNT) {
            val number = random.nextInt(PENSION_MAX_NUMBER - PENSION_MIN_NUMBER + 1) + PENSION_MIN_NUMBER
            numbers.add(number)
        }

        // 조 번호 + 오름차순 정렬된 숫자
        return listOf(groupNumber) + numbers.sorted()

    }
}