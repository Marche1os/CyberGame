package com.marchelos.player.skill

@JvmInline
value class SkillName(val value: String) {
    init {
        require(value.isNotBlank())
    }
}