package com.marchelos.player.hero

import com.marchelos.economy.Money
import com.marchelos.player.skill.Skill
import com.marchelos.player.skill.SkillId

interface Hero {

    // Атрибуты
    val attrs: HeroAttributes

    // Команды
    fun learnSkill(skill: Skill)

    // Запросы
    fun currentMoney(): Money

    fun getSkillBy(skillId: String): Skill
}