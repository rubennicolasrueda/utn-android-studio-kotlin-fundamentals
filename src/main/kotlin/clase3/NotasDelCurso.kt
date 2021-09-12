package clase3

// Ejercicio - Notas del curso

fun main() {
    var sumaNotas = 0
    var esAplazo = false
    var cantidadDeNotas = obtenerCantidadDeNotas()
    for (i in 0 until cantidadDeNotas) {
        println("Ingrese la nota")
        var nota = readLine()!!.toInt()
        esAplazo = verificarSiEsAplazo(nota)
        sumaNotas += nota
    }
    var promedio = obtenerPromedio(sumaNotas, cantidadDeNotas)
    mostrarResultados(promedio, esAplazo)
}

fun verificarSiEsAplazo(nota: Int): Boolean {
    return nota <= 3
}

fun obtenerCantidadDeNotas(): Int {
    var cantidadDeNotas = 0
    var respuesta = "n"
    while (respuesta != "y") {
        println("Ingrese una cantidad de notas")
        cantidadDeNotas = readLine()!!.toInt()
        println("""¿El número ingresado es correcto?(presione "y" para sí)""")
        respuesta = readLine().toString()
    }
    return cantidadDeNotas
}

fun obtenerPromedio(sumaNotas: Int, cantidadDeNotas: Int): Float {
    return sumaNotas.toFloat() / cantidadDeNotas.toFloat()
}

fun mostrarResultados(promedio: Float, esAplazo: Boolean) {
    println("El promedio de las notas es $promedio")
    if (promedio >= 6 && !esAplazo) {
        println("APROBADO")
    } else {
        if (!esAplazo) {
            print("A RECUPERATORIO")
        } else {
            println("NO APROBADO")
        }
    }
}
