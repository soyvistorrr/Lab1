import java.io.File
import java.util.ArrayDeque

fun obtenerGrado(grafo: Grafo<String>, inicio: String, fin: String): Int {
    if (inicio == fin) return 0
    if (!grafo.contiene(inicio) || !grafo.contiene(fin)) return -1

    val cola = ArrayDeque<String>()
    val distancias = mutableMapOf<String, Int>()

    cola.add(inicio)
    distancias[inicio] = 0

    while (cola.isNotEmpty()) {
        val actual = cola.removeFirst()
        val distActual = distancias[actual]!!

        val vecinos = grafo.obtenerArcosSalida(actual)
        
        vecinos.forEach { vecino ->
            if (vecino == fin) return distActual + 1
            
            if (vecino !in distancias) {
                distancias[vecino] = distActual + 1
                cola.add(vecino)
            }
        }
    }
    return -1
}

fun main(args: Array<String>) {
    // Validación de argumentos
    if (args.size < 2) {
        println("Por favor ingrese dos nombres.")
        return
    }

    val personaA = args[0]
    val personaB = args[1]
    val grafo: Grafo<String> = ListaAdyacenciaGrafo()

    val archivo = File("input.txt")
    if (archivo.exists()) {
        archivo.forEachLine { linea ->
            val partes = linea.trim().split(" ")
            if (partes.size >= 2) {
                val p1 = partes[0]
                val p2 = partes[1]
                
                grafo.agregarVertice(p1)
                grafo.agregarVertice(p2)
                grafo.conectar(p1, p2)
                grafo.conectar(p2, p1)
            }
        }
    } else {
        println("No se encontró input.txt")
        return
    }

    val resultado = obtenerGrado(grafo, personaA, personaB)
    println(resultado)
}