package Ecuaciones_Lineales;

public class Lanzador_gauss {
    static void main(String[] args) {
        // Obtiene la matriz aumentada del sistema
        double [][] matriz = Defmatrizz.defmatriz();

        System.out.println("Matriz aumentada inicial: ");
        imprimirMatriz(matriz);

        // Convierte la matriz en triangular superior
        Gauss.eliminacionGaussiana(matriz);

        // Despeja las incógnitas de abajo hacia arriba
        double[] soluciones = Gauss.sustitucionRegresiva(matriz);
        System.out.println();

        // Imprime cada solución: x1, x2, x3...
        System.out.println("Soluciones del sistema:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i + 1) + " = "  + soluciones[i]);
        }

        System.out.println("-----------------------------------------");

        GaussJordan.resolver(matriz);

        System.out.println("Matriz final (identidad): ");
        imprimirMatriz(matriz);

        System.out.println();

        double [] x = GaussJordan.obtenerSoluciones(matriz);
        System.out.println("Soluciones por Gauss Jordan:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d = %.4f%n", i +1, x[i]);
        }
        System.out.println("-----------------------------------------");
    }
    private static void
    imprimirMatriz(double[][] matriz){
        for (double[] fila : matriz) {
            for (double v : fila) {
                System.out.printf("%10.4f", v);
            }
            System.out.println();
        }
    }
}