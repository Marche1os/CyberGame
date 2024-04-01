package com.marchelos.quest.mission

import com.marchelos.player.Skill

interface Mission {
    // Атрибуты:
    val attrs: MissionAttributes

    // Команды:

    // Предусловие: миссия доступна к выполнению
    // Постусловие: таймер взлома запустился
    fun startHacking()

    // предусловие: навык ранее не применялся и таймер на взлом не истек
    // постусловие: эффект от навыка применен
    fun applySkill(skill: Skill)
}