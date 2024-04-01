package com.marchelos.player.hero

/**
 * Очки, за которые приобретаются навыки
 */
@JvmInline
value class Points(val value: Int) {
    init {
        require(value > 0)
    }


}