package com.marchelos.quest.digital_system

@JvmInline
value class DigitalSystemComplexityLevel(val value: Int) {

    init {
        require(value in MIN_COMPLEXITY..MAX_COMPLEXITY)
    }

    companion object {
        const val MIN_COMPLEXITY = 1
        const val MAX_COMPLEXITY = 5
    }
}