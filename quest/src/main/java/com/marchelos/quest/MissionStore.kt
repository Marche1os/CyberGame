package com.marchelos.quest

import com.marchelos.quest.mission.Mission
import com.marchelos.quest.mission.MissionAttributes
import com.marchelos.quest.mission.MissionId
import com.marchelos.quest.mission.MissionImpl
import com.marchelos.quest.mission.MissionTimer
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

object MissionStore {
    private val missions: MutableMap<MissionId, Mission> = mutableMapOf()
    private val lock = ReentrantLock()

    fun store(missions: List<Mission>) {
        lock.withLock {
            this.missions.putAll(
                missions.associateBy { mission -> mission.attrs.id }
            )
        }
    }

    fun readBy(missionId: MissionId): Mission = missions.getValue(missionId)

    fun readBy(missionId: String): Mission = missions.mapKeys { it.key.value }.getValue(missionId)

    fun readAll(): Map<MissionId, Mission> = missions

    object Generator {
        fun generate() {
            val data = buildList<Mission> {
                repeat(3) {
                    add(
                        MissionImpl(
                            MissionAttributes(
                                MissionId("№$it"),
                                MissionTimer(10),
                            )
                        )
                    )
                }
            }
            store(data)
        }
    }
}