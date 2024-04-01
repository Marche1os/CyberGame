package com.marchelos.quest.mission

import com.marchelos.player.skill.Skill
import com.marchelos.quest.ObserveListener

class MissionImpl(
    private val attributes: MissionAttributes,
) : Mission {
    override val attrs: MissionAttributes
        get() = attributes

    override fun startHacking() {
        require(MissionAttributes.Status.OPENED == currentStatus())

        changeMissionStatusTo { MissionAttributes.Status.PROCESSING }

        attrs.timer.addListener(
            object : ObserveListener<Int> {
                override fun observe(value: Int) {
                    if (value == 0) {
                        changeMissionStatusTo { MissionAttributes.Status.FAILED }
                    }
                }
            }
        )
    }

    private fun currentStatus() = attrs.status

    override fun applySkill(skill: Skill) {
        attrs.timer.reduceByPercent(skill.currentLevel().value)
    }

    private inline fun changeMissionStatusTo(operation: () -> MissionAttributes.Status) {
        attrs.status = operation()
    }
}