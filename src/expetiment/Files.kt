package expetiment

import java.io.File
import java.nio.file.Files
import kotlin.system.measureTimeMillis

fun main(){

    val took = measureTimeMillis {

        repeat(1000){
            val file = File("/Users/emix/sandbox/go/example")
            file.createNewFile()

            file.writeText("some text")

            Files.delete(file.toPath())
        }
    }

    println("done in $took")
}