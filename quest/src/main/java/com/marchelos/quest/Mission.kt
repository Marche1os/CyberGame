package com.marchelos.quest

import com.marchelos.quest.mission.MissionAttributes

interface Mission {
    // Атрибуты:
    val attrs: MissionAttributes

    // Команды:

    fun startHacking()

    // Подписаться на таймер. Таймер - это максимальное время на взлом.
    fun observeOnTimer(observeListener: ObserveListener<Int>)
}