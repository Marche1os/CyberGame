package com.marchelos.quest.mission

import com.marchelos.quest.digital_system.DigitalSystemId

data class MissionAttributes(
    val id: MissionId,
    val systemToHack: DigitalSystemId,
    val timer: MissionTimer,
)
