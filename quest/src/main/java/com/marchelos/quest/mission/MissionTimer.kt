package com.marchelos.quest.mission

import com.marchelos.quest.ObserveListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.LinkedList

class MissionTimer(
    private var seconds: Int
) {
    private val listeners: LinkedList<ObserveListener<Int>> = LinkedList()

    fun addListener(observeListener: ObserveListener<Int>) {
        listeners.add(observeListener)
    }

    fun startTimer() {
        runBlocking {
            withContext(Dispatchers.Default) {
                while (seconds > 0) {
                    delay(1000)
                    seconds--
                    listeners.forEach { it.observe(seconds) }
                }
            }
        }
    }

    fun clear() {
        listeners.clear()
    }
}