package com.marchelos.quest.mission

import com.marchelos.quest.mission.MissionAttributes.Status.COMPLETED
import com.marchelos.quest.mission.MissionAttributes.Status.FAILED
import com.marchelos.quest.mission.MissionAttributes.Status.OPENED
import com.marchelos.quest.mission.MissionAttributes.Status.PROCESSING
import com.marchelos.quest.mission.MissionAttributes.Status.UNAVAILABLE

data class MissionAttributes(
    val id: MissionId,
//    val systemToHack: DigitalSystemId,
    val timer: MissionTimer,
    var status: Status = Status.OPENED,
) {

    /**
     * Статус миссии:
     * [COMPLETED] - миссия выполнена
     * [OPENED] - миссия доступна к прохождению
     * [UNAVAILABLE] - Миссия недоступна в данный момент, требуется выполнить связанное задание
     * [PROCESSING] - Миссия в процессе выполнения
     * [FAILED] - Время на выполнение миссии истекло
     */
    sealed interface Status {
        data object COMPLETED : Status
        data object OPENED : Status
        data object UNAVAILABLE : Status
        data object PROCESSING : Status
        data object FAILED : Status
    }

    fun changeStatusToProcessing() {
        status = Status.PROCESSING
    }
}
