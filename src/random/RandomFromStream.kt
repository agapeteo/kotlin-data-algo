package random

import java.util.*
import java.util.stream.Stream

object RandomFromStream {

    fun <T> random(stream: Stream<T>): T? {
        val rnd = Random()

        var result: T? = null

        var i = 0
        stream.forEach { element ->
            i += 1
            if (i == 1) {
                result = element
                return@forEach
            }

            val rndIdx = 1 + rnd.nextInt(i)
            if (rndIdx == i) {
                result = element
            }
        }
        return result
    }
}

