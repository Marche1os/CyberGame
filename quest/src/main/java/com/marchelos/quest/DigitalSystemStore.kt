package com.marchelos.quest

import com.marchelos.quest.digital_system.DigitalSystem
import com.marchelos.quest.digital_system.DigitalSystemId
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * In-memory storage, содержащий множество цифровых систем
 */
class DigitalSystemStore {
    private val digitalSystems: MutableMap<DigitalSystemId, DigitalSystem> = mutableMapOf()
    private val mutex = ReentrantLock()

    fun store(systems: List<DigitalSystem>) {
        mutex.withLock {
            digitalSystems.putAll(
                systems.associateBy { system -> system.digitalSystemAttributes.id }
            )
        }
    }

    fun readById(id: DigitalSystemId): DigitalSystem = digitalSystems.getValue(id)
}