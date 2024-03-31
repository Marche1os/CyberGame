package com.marchelos.quest.mission

/**
 * Идентификатор задания.
 * @param value не должен быть пустым
 */

@JvmInline
value class MissionId(val value: String) {
    init {
        require(value.isNotBlank())
    }
}