# Ecuaciones Lineales en Java

Este proyecto resuelve sistemas de ecuaciones lineales con dos métodos: Gauss y Gauss-Jordan. Los dos se prueban con el mismo sistema para ver que den lo mismo.

## Cómo está organizado

Todo está en el paquete `Ecuaciones_Lineales` y lo dividí en 4 clases para no tener todo revuelto:

```text
src/Ecuaciones_Lineales/
    Defmatrizz.java
    Gauss.java
    GaussJordan.java
    Lanzador_gauss.java
```

- `Defmatrizz`: aquí está la matriz del sistema. Si quieres probar otro sistema, solo cambias los números de esta clase.
- `Gauss`: deja la matriz triangular y luego despeja las incógnitas de abajo hacia arriba. Le puse pivoteo parcial para que no truene si hay un cero en la diagonal.
- `GaussJordan`: usa lo de `Gauss` y después sigue hasta dejar la matriz identidad, así las soluciones quedan en la última columna.
- `Lanzador_gauss`: tiene el `main`. Corre los dos métodos y muestra los resultados.

## Cómo correrlo

Necesitas tener el JDK instalado (yo usé el 21). Abre la terminal en la carpeta principal del proyecto, donde está `src`, y pon esto:

Para compilar:

```bash
javac -d out src/Ecuaciones_Lineales/*.java
```

Para ejecutar:

```bash
java -cp out Ecuaciones_Lineales.Lanzador_gauss
```

## Ejemplo

Usé este sistema, que es el que viene ya puesto en `Defmatrizz`:

```text
3.0x1 - 0.1x2 - 0.2x3 = 7.85
0.1x1 + 7.0x2 - 0.3x3 = -19.3
0.3x1 - 0.2x2 + 10.0x3 = 71.4
```

La respuesta que debería salir es x1 = 3, x2 = -2.5 y x3 = 7.

Esto es lo que sale en la consola:

```text
Matriz aumentada inicial: 
    3.0000   -0.1000   -0.2000    7.8500
    0.1000    7.0000   -0.3000  -19.3000
    0.3000   -0.2000   10.0000   71.4000

Soluciones por Gauss:
x1 = 3.0000
x2 = -2.5000
x3 = 7.0000
-----------------------------------------
Matriz final [I | x]: 
    1.0000    0.0000    0.0000    3.0000
    0.0000    1.0000    0.0000   -2.5000
    0.0000    0.0000    1.0000    7.0000

Soluciones por Gauss-Jordan:
x1 = 3.0000
x2 = -2.5000
x3 = 7.0000
-----------------------------------------
```

Como se ve, los dos métodos llegan a la misma respuesta.