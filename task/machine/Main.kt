package machine

var water = 400
var milk = 540
var coffeeBeans = 120
var disposableCups = 9
var money = 550

class CoffeeMachine {

    private fun machineContent() {
        println(
            "\nThe coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$coffeeBeans g of coffee beans\n" +
                    "$disposableCups disposable cups\n" +
                    "\$${money} of money\n"
        )
    }

    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int, beansNeeded: Int, cost: Int) {
        when {
            water < waterNeeded -> println("\nSorry, not enough water!")
            milk < milkNeeded -> println("\nSorry, not enough milk!")
            coffeeBeans < beansNeeded -> println("\nSorry, not enough coffee beans!")
            disposableCups < 1 -> println("\nSorry, not enough disposable cups!")
            else -> {
                println("I have enough resources, making you a coffee!\n")
                water -= waterNeeded
                milk -= milkNeeded
                coffeeBeans -= beansNeeded
                disposableCups--
                money += cost
            }
        }
    }

    fun menu() {
        while (true) {
            println("Write action (buy, fill, take, remaining, exit):")
            when (readln()) {
                "buy" -> {
                    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    when (readln()) {
                        "1" -> makeCoffee(250, 0, 16, 4)
                        "2" -> makeCoffee(350, 75, 20, 7)
                        "3" -> makeCoffee(200, 100, 12, 6)
                        "back" -> continue
                    }
                }

                "fill" -> {
                    print("Write how many ml of water do you want to add:\n ")
                    water += readln().toInt()
                    print("Write how many ml of milk do you want to add:\n ")
                    milk += readln().toInt()
                    print("Write how many grams of coffee beans do you want to add:\n ")
                    coffeeBeans += readln().toInt()
                    print("Write how many disposable cups of coffee do you want to add:\n ")
                    disposableCups += readln().toInt()
                    println()
                }

                "take" -> {
                    println("I gave you $$money\n")
                    money = 0
                }

                "remaining" -> machineContent()
                "exit" -> return
            }
        }
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.menu()
}