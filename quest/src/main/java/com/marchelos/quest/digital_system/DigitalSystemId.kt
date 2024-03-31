package com.marchelos.quest.digital_system

@JvmInline
value class DigitalSystemId(val value: String) {

    init {
        require(value.isNotBlank())
    }
}