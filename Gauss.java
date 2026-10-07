package Ecuaciones_Lineales;

public class Gauss {

    // Convierte la matriz aumentada en una matriz triangular superior
    public static void eliminacionGaussiana(double[][] matriz){
        int n = matriz.length;

        // i = fila pivote actual
        for(int i = 0; i < n; i++){

            // j = filas debajo del pivote, donde se harán ceros
            for(int j = i + 1; j < n; j++){

                // Cuánto hay que restar para anular matriz[j][i]
                double factor = matriz[j][i] / matriz [i][i];

                // Fila j = fila j - factor * fila pivote (incluye la columna n, el término independiente)
                for(int k = i; k <= n; k++){
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }
    }

    // Resuelve el sistema triangular de abajo hacia arriba
    public static double[] sustitucionRegresiva(double[][] matriz){
        int n = matriz.length;
        double[] x = new double[n];// arreglo de soluciones

        // Se empieza en la última ecuación y se sube
        for(int i = n - 1; i >= 0; i--){
            double suma = 0;

            // Suma de los términos con incógnitas ya conocidas
            for(int j = i + 1; j < n; j++){
                suma += matriz[i][j] * x[j];
            }

            // Despeja la incógnita: (término independiente - suma) / coeficiente
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }
        return x;
    }
}