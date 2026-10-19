package Ecuaciones_Lineales;

public class GaussJordan {

    // Convierte la matriz aumentada [A | b] en [I | x]
    public static void resolver(double[][] matriz){
        int n = matriz.length;

        // Paso 1: reutiliza la eliminación gaussiana (matriz triangular superior)
        Gauss.eliminacionGaussiana(matriz);

        // Paso 2: de abajo hacia arriba, normaliza y barre hacia arriba
        for(int i = n - 1; i >= 0; i--){

            // Normaliza: el pivote pasa a ser 1
            double pivote = matriz[i][i];
            for(int k = i; k <= n; k++){
                matriz[i][k] /= pivote;
            }

            // Barrido superior: ceros arriba del pivote
            for(int j = i - 1; j >= 0; j--){
                double factor = matriz[j][i];
                for(int k = i; k <= n; k++){
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    // Paso 3: lectura directa de la última columna (matriz[i][n])
    public static double[] obtenerSoluciones(double[][] matriz){
        int n = matriz.length;
        double[] x = new double[n];

        for(int i = 0; i < n; i++){
            x[i] = matriz[i][n];
        }
        return x;
    }
}