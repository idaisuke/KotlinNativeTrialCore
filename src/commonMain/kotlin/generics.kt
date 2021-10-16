package example

class Box<T>(t: T) {
    var value = t
}

abstract class Source<out T> {
    abstract fun nextT(): T
}

abstract class Comparable<in T> {
    abstract fun compareTo(other: T): Int
}

fun <T> basicToList(item: T): List<T> = listOf(item)

fun <T> T.basicToString(): String = "$this"
