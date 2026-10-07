fun main() {
    var opcion: Int

    do {
        mostrarMenu()
        opcion = leerOpcion()

        when (opcion) {
            1, 2, 3, 4, 5 -> {
                val num1 = leerNumero("Introduce el primer número: ")
                val num2 = leerNumero("Introduce el segundo número: ")

                when (opcion) {
                    1 -> println("El resultado de la suma es: ${num1 + num2}")
                    2 -> println("El resultado de la resta es: ${num1 - num2}")
                    3 -> println("El resultado de la multiplicación es: ${num1 * num2}")
                    4 -> {
                        if (num2 == 0.0) {
                            println("Error: no se puede dividir entre cero.")
                        } else {
                            println("El resultado de la división es: ${num1 / num2}")
                        }
                    }
                    5 -> {
                        if (num2 == 0.0) {
                            println("Error: no se puede calcular el resto si el segundo número es cero.")
                        } else {
                            println("El resto de la división es: ${num1 % num2}")
                        }
                    }
                }
            }
            6 -> println("Saliendo de la calculadora...")
            else -> println("Error: opción no válida. Elige un número del 1 al 6.")
        }

        println()
    } while (opcion != 6)
}

fun mostrarMenu() {
    println("===== CALCULADORA BÁSICA =====")
    println("1. Sumar")
    println("2. Restar")
    println("3. Multiplicar")
    println("4. Dividir")
    println("5. Calcular resto")
    println("6. Salir")
    print("Seleccione una opción: ")
}

// Devuelve la opción como Int; si el usuario escribe algo no numérico, devuelve -1
fun leerOpcion(): Int {
    return readlnOrNull()?.trim()?.toIntOrNull() ?: -1
}

// Pide un número hasta que el usuario introduce un valor válido
fun leerNumero(mensaje: String): Double {
    while (true) {
        print(mensaje)
        // Se admite la coma decimal además del punto
        val numero = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull()
        if (numero != null) {
            return numero
        }
        println("Error: debes introducir un número válido.")
    }
}