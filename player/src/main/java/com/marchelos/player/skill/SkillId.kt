package com.marchelos.player.skill

@JvmInline
value class SkillId(val value: String) {
    init {
        require(value.isNotBlank())
    }
}