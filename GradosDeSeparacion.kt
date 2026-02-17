import java.io.File
import java.util.ArrayDeque

class GradosDeSeparacion<T> {
    private val amigos = mutableMapOf<T, MutableList<T>>()

    fun conectar(desde: T, hasta: T): Boolean {
        amigos.getOrPut(desde) { mutableListOf() }.add(hasta)
        amigos.getOrPut(hasta) { mutableListOf() }.add(desde)
        return true
    }

    fun obtenerGrado(inicio: T, fin: T): Int {
        if (inicio == fin) return 0
        if (inicio !in amigos || fin !in amigos) return -1

        val cola = ArrayDeque<T>()
        val distancias = mutableMapOf<T, Int>()

        cola.add(inicio)
        distancias[inicio] = 0

        while (cola.isNotEmpty()) {
            val actual = cola.removeFirst()
            val distActual = distancias[actual]!!

            amigos[actual]?.forEach { vecino ->
                if (vecino == fin) return distActual + 1
                
                if (vecino !in distancias) {
                    distancias[vecino] = distActual + 1
                    cola.add(vecino) 
                }
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        return
    }

    val personaA = args[0]
    val personaB = args[1]
    val grafo = GradosDeSeparacion<String>()

    val archivo = File("input.txt")
    if (archivo.exists()) {
        archivo.forEachLine { linea ->
            val partes = linea.trim().split(" ")
            if (partes.size >= 2) {
                grafo.conectar(partes[0], partes[1])
            }
        }
    }

    val resultado = grafo.obtenerGrado(personaA, personaB)
    println(resultado)
}