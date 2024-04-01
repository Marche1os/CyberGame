package com.marchelos.player.skill

@JvmInline
value class SkillDescription(val value: String) {
    init {
        require(value.count() >= MIN_DESCRIPTION_CHARS)
    }

    companion object {
        private const val MIN_DESCRIPTION_CHARS = 3
    }
}