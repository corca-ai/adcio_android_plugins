package scripts

import ai.corca.dacs.DacsProvider

fun main() {
    val result = DacsProvider().greet()
    println("Result: $result")
}