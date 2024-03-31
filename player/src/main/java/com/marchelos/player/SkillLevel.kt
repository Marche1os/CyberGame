package com.marchelos.player

/**
 * Уровень прокачки навыка. Содержит значение в диапазоне от 1 до 10
 */
@JvmInline
value class SkillLevel(val value: Int) {
    init {
        require(value in MIN_LEVEL..MAX_LEVEL)
    }

    fun increaseLevel() = SkillLevel(value + 1)

    companion object {
        const val MIN_LEVEL = 1
        const val MAX_LEVEL = 10
    }
}