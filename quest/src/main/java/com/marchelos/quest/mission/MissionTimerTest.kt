package com.marchelos.quest.mission

import com.marchelos.quest.ObserveListener
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MissionTimerTest {
    @Test
    fun startTimer() {
        var seconds = 5
        val timer = newTimer(seconds)
        val listener = object : ObserveListener<Int> {
            override fun observe(value: Int) {
                seconds--
                assert(value == seconds)
            }
        }
        timer.addListener(listener)

        timer.startTimer()
    }

    @Test
    fun checkReduceBy() {
        var seconds = 89
        val timer = newTimer(100)

        val listener = object : ObserveListener<Int> {
            override fun observe(value: Int) {
                assert(value == seconds--)
            }
        }

        timer.addListener(listener)
        timer.increaseTimerByPercent(10)
        timer.startTimer()
    }

    @Test
    fun startTimerWithoutListeners() {
        val timer = newTimer()
        assertThrows<IllegalArgumentException> {
            timer.startTimer()
        }
    }

    private fun newTimer(initialSeconds: Int = 5) = MissionTimer(initialSeconds)
}