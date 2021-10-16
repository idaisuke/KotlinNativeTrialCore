package example

class Person(val firstName: String, val lastName: String, var age: Int = 20)

fun Person.extension() = "Person.extension"

interface Animal {
    val property: String get() = "Animal.property"
}

class Dog : Animal

open class Base() {
    open fun v() = "Base.v()"
    fun nv() = "Base.nv()"
}

class Derived : Base() {
    override fun v(): String = "Derived.v()"
}

abstract class Abstract {
    abstract fun v(): String
    fun nv() = "Abstract.nv()"
}

sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

data class User(val name: String, val age: Int)

object Singleton {
    val property = "Singleton.property"
}

class MyClass {
    companion object {
        val property = "MyClass.Companion.property"
    }
}
