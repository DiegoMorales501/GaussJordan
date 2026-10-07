package Ecuaciones_Lineales;

public class Defmatrizz {

    // Devuelve la matriz aumentada [A | b] del sistema de ecuaciones
    public static double[][] defmatriz(){
        return new double[][]{
                // Columnas: coef. x1, coef. x2, coef. x3, término independiente
                {3.0, -0.1, -.2, 7.85},
                { 0.1, 7.0, -0.3, -19.3},
                { 0.3, -0.2, 10.0, 71.4}
        };
    }
}