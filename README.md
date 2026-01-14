# Reto 11

**Arquitectura, estilo MVC (Model-View-Controller) con paquete Command:**
El proyecto desacopla la estructura del grafo de la lógica de cálculo de rutas. En el paquete **model**, `ReactorNetwork` representa el grafo de conexiones y encapsula el algoritmo central de búsqueda (DFS con Memoization). En el paquete **view**, `ConsoleVisualizer` se encarga de mostrar los resultados. En **controller**, `NetworkController` organiza el flujo: transforma el texto de entrada en un grafo de objetos y selecciona la estrategia de cálculo adecuada (ruta simple o con hitos).

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Cada clase tiene un propósito acotado. `FileInputReader` maneja la I/O, `ReactorNetwork` solo sabe calcular rutas entre dos puntos dados, y los comandos (`DirectPathCalculation`, `WaypointPathCalculation`) definen que tramos calcular y cómo combinarlos.
* **Inversión de Dependencias (DIP):** El código depende de abstracciones. El uso de la interfaz `PathCommand` permite que el sistema ejecute diferentes tipos de cálculos de trayectoria sin acoplarse a una implementación concreta.
* **Abierto-Cerrado (OCP):** El diseño es extensible. Si se requiere un nuevo tipo de ruta, basta con crear un nuevo record que lo implemente sin tocar la lógica recursiva del modelo ni el controlador.

**Extras:**
* **Patrón Command:** Encapsula las diferentes lógicas de negocio (Camino directo vs Camino con paradas intermedias).
* **Memoización:** Implementada en `ReactorNetwork` (`Map<String, Long> cache`). Esto optimiza drásticamente el algoritmo, evitando recalcular caminos en sub-árboles ya visitados, convirtiendo una complejidad exponencial en lineal/cuadrática.
* **Java Records:** Uso de `DirectPathCalculation` y `WaypointPathCalculation` para definir comandos inmutables de forma concisa.
* **Combinatoria de Rutas:** Aplicación del principio de multiplicación en `WaypointPathCalculation` (Rutas A->B * Rutas B->C) para calcular totales sin necesidad de simular el camino completo de una sola vez.
