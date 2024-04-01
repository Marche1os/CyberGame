package com.marchelos.player.hero

import com.marchelos.economy.Money
import com.marchelos.player.skill.Skill

data class HeroAttributes(
    val balance: Money,
    val skills: Set<Skill>,
    var points: Points,
)