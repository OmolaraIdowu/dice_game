package com.swancodes.dicegame

fun main() {

    // Create car objects and assign it to myFirstCar and mySecondCar
    val myFirstCar = Car("Bugatti", "Green")
    println(myFirstCar.wheels)
    myFirstCar.cost()

    val mySecondCar = Car("Porsche", "Black")
    println(mySecondCar.windows)
    mySecondCar.cost()
}

// Car class with color and name properties
open class Car(open val name: String, open val color: String) {

    // Properties
    val wheels = 4
    val windows = 4

    // Cost function
    fun cost() {
        val cost = 30000000
        println(cost)
    }
}

class Motorcycle(override val name: String, override val color: String) : Car("Chopper", "Blue")