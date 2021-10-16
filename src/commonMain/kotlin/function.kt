package example

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun forIntegers(b: Byte, s: UShort, i: Int, l: ULong?) {
    println(b)
    println(s)
    println(i)
    println(l)
}

fun forFloats(f: Float, d: Double?) {
    println(f)
    println(d)
}

fun strings(str: String?): String {
    return "That is '$str' from C"
}

fun acceptFun(f: (String) -> String?) = f("Kotlin/Native rocks!")
fun supplyFun(): (String) -> String? = { "$it is cool!" }

suspend fun suspend() = suspendCoroutine<String> {
    it.resume("suspend")
}
