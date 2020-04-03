package concurrency

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.system.measureTimeMillis

class Philosophers {
    val verbose = true
    val maxAwaitTimeForDinner = 30L
    val maxEatTimeSeconds = 2
    val philosophersCount = 6

    val countDownLatch = CountDownLatch(philosophersCount)

    fun startDinner() {
        var firstStick: Stick? = null

        var leftStick: Stick? = null
        var rightStick: Stick? = null

        val threadPool = Executors.newWorkStealingPool()

        for (i in 0..philosophersCount) {
            val stick = Stick(i)

            if (i == 0) {
                firstStick = stick
                leftStick = stick
                continue
            }
            if (i == 1) {
                rightStick = stick
            } else if (i == philosophersCount) {
                leftStick = rightStick
                rightStick = firstStick
            } else {
                leftStick = rightStick
                rightStick = stick
            }
            val philosopher = Philosopher(i, leftStick!!, rightStick!!)
            echo("philosopher ${philosopher.number} got leftStick ${philosopher.leftStick.number}, rightStick ${philosopher.rightStick.number}")

            threadPool.submit { philosopher.eat() }
        }
        threadPool.shutdown()

        val allCompleted = countDownLatch.await(maxAwaitTimeForDinner, TimeUnit.SECONDS)

        val resultMessage = if (allCompleted) "all philosophers are satisfied" else "some philosophers still hungry. deadlock?"
        echo("\n$resultMessage")
    }

    data class Stick(val number: Int, val lock: Lock = ReentrantLock())

    data class Philosopher(val number: Int, val leftStick: Stick, val rightStick: Stick, var curTimeEatSpent: Int = 0)

    private fun Philosopher.eat() {
        fun eatRandomTime() {
            val rndTime = (1..(maxEatTimeSeconds - curTimeEatSpent)).random()

            echo("philosopher $number -> started to eat with sticks leftStick ${leftStick.number}, rightStick ${rightStick.number}")

            pause(rndTime * 1000L)
            pause(rndTime * 1000L)
            curTimeEatSpent += rndTime

            echo("philosopher $number <- finished to eat with sticks leftStick ${leftStick.number}, rightStick ${rightStick.number} in $rndTime seconds")
        }

        while (curTimeEatSpent < maxEatTimeSeconds) {
            if (!leftStick.lock.tryLock()) {
                echo("philosopher $number tried taking left stick ${leftStick.number}, but was locked")
                pause(250)
                continue
            }
            try {
                if (!rightStick.lock.tryLock()) {
                    echo("philosopher $number tried taking right stick ${rightStick.number}, but was locked")
                    pause(250)
                    continue
                }
                try {
                    eatRandomTime()
                } finally {
                    rightStick.lock.unlock()
                }
            } finally {
                leftStick.lock.unlock()
                pause(50)
            }
        }
        countDownLatch.countDown()
        echo("\n--> philosopher $number finished dinner !!\n")
        pause(133)
    }

    fun echo(msg: String) {
        if (verbose) println(msg)
    }
}

fun pause(time: Long) {
    Thread.sleep(time)
}

fun main() {
    var total = 0L
    repeat(50) {
        val timeElapsed = measureTimeMillis {
            Philosophers().startDinner()
        }
        println("\n dinner took ${timeElapsed / 1000} seconds")
        total += timeElapsed / 1000
    }
    println("average: ${total/50}")


}
