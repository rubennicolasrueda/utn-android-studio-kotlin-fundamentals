package clase3

// Ejercicio - Vending machine

fun main() {
    var precioProducto: Float
    var cantidadDinero: Float
    do {
        precioProducto = obtenerPrecioProducto()
        cantidadDinero = obtenerCantidadDinero()
        val esPagoSuficiente = validarPagoSuficiente(precioProducto, cantidadDinero)
    } while (!esPagoSuficiente)

    var vuelto = obtenerVuelto(cantidadDinero, precioProducto)

    calcularBilletesYMostrarVuelto(vuelto)
}

fun obtenerPrecioProducto(): Float {
    println("Ingrese el precio del producto")
    return readLine()!!.toFloat()
}

fun obtenerCantidadDinero(): Float {
    println("Ingrese la cantidad de dinero")
    return readLine()!!.toFloat()
}

fun validarPagoSuficiente(precioProducto: Float, cantidadDinero: Float): Boolean {
    val esPagoSuficiente = cantidadDinero >= precioProducto
    if (!esPagoSuficiente) println("El dinero ingresado no es suficiente, reintentar.")
    return esPagoSuficiente
}

fun obtenerVuelto(cantidadDinero: Float, precioProducto: Float) = cantidadDinero - precioProducto

fun calcularBilletesYMostrarVuelto(vuelto: Float) {
    var vuelto = vuelto
    var valorBilletes = arrayOf(100, 50, 20, 10, 5, 2, 1)
    var cantidadBilletes = IntArray(valorBilletes.size)

    for ((contador, i) in valorBilletes.withIndex()) {
        if (vuelto >= i) {
            cantidadBilletes[contador] = vuelto.toInt() / valorBilletes[contador]
            vuelto %= i
        }
    }
    mostrarVuelto(cantidadBilletes, valorBilletes)
}

fun mostrarVuelto(cantidadBilletes: IntArray, valorBilletes: Array<Int>) {
    println("¡Su vuelto!")
    for ((contador) in valorBilletes.withIndex()) {
        println("${cantidadBilletes[contador]} billetes de $${valorBilletes[contador]}")
    }
}
