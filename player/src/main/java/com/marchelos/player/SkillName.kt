package com.marchelos.player

@JvmInline
value class SkillName(val value: String) {
    init {
        require(value.isNotBlank())
    }
}