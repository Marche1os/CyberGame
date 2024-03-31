package com.marchelos.player

@JvmInline
value class SkillId(val value: String) {
    init {
        require(value.isNotBlank())
    }
}