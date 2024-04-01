package com.marchelos.player.hero

import com.marchelos.economy.Money

interface Hero {

    // Атрибуты
    val attrs: HeroAttributes

    // Запросы
    fun currentMoney(): Money
}