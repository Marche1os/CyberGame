package com.marchelos.quest.digital_system

import com.marchelos.player.Skill
import com.marchelos.quest.digital_system.DigitalSystemAttributes

/**
 * АТД Цифровая система, предназначенная для взлома игроком. Является целью задания
 */
interface DigitalSystem {
    // Атрибуты
    val digitalSystemAttributes: DigitalSystemAttributes

    // Команды:

    // предусловие: навык ранее не применялся и таймер на взлом не истек
    // постусловие: эффект от навыка применен
    fun applySkill(skill: Skill)

}