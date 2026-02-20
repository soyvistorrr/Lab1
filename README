# CI-2693 - Laboratorio de Algoritmos y Estructuras III

## Laboratorio 1: Grados de separación

**Estudiante:** Victor Hernandez
**Carnet:** 20-10349

---

## Descripción del Proyecto

Este proyecto implementa una solución en Kotlin para calcular los grados de separación entre dos personas. Dado que la relación de amistad es bidireccional, el sistema modela la red como un grafo simétrico (no dirigido).

## Estructura de Datos y Algoritmo

Para representar la red social, se utilizó la estructura de `ListaAdyacenciaGrafo` implementada en el Proyecto 1, la explicacion de su funcionamiento se encuentra en el README de el repositorio correspondiente a la misma.

Para el cálculo de los grados de separación, se implementó el algoritmo de **Búsqueda en Anchura (BFS)**. Al explorar el grafo nivel por nivel usando una cola (FIFO), el BFS garantiza matemáticamente que la primera vez que se alcanza el vértice destino, el camino recorrido es el mínimo posible.

## Requisitos

* Compilador de Kotlin (`kotlinc`)
* Java Runtime Environment (`java`)

## Compilación y Ejecución

**Compilar el código:** Para asegurar que todas las referencias a las interfaces y clases del grafo se resuelvan correctamente, compila todos los archivos `.kt` del directorio generando un archivo `.jar`:

```bash
kotlinc *.kt -include-runtime -d DegreesOfSeparation.jar
```

**Ejecutar el programa:** El programa requiere dos argumentos de línea de comandos correspondientes a los nombres de las dos personas a consultar. Además, requiere que exista un archivo input.txt en el mismo directorio con los pares de amistades.

```bash
java -jar DegreesOfSeparation.jar <Persona1> <Persona2>
```

**Ejemplo de uso:**

```bash
java -jar DegreesOfSeparation.jar Carlos Ana
```
