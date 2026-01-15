package io;

/**
 *Clase para validar que la matriz este lista para procesarla
 * */

public class ValidadorMatriz {

    public static void validar(int[][] matriz) {
        validarNoNula(matriz);
        validarRectangular(matriz);
        validarCuadrada(matriz);
        validarValoresPermitidos(matriz);
    }

    private static void validarNoNula(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("Error: Matriz nula.");
        }
        if (matriz.length == 0) {
            throw new IllegalArgumentException("Error: Matriz sin filas.");
        }
    }

    private static void validarRectangular(int[][] matriz) {
        int columnas = matriz[0].length;
        if (columnas == 0) {
            throw new IllegalArgumentException("Error: Matriz sin columnas.");
        }

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == null) {
                throw new IllegalArgumentException("Error: Fila " + (i + 1) + " es nula.");
            }
            if (matriz[i].length != columnas) {
                throw new IllegalArgumentException("Error: La fila " + (i + 1)
                        + " tiene " + matriz[i].length + " columnas en lugar de " + columnas + ".");
            }
        }
    }

    private static void validarCuadrada(int[][] matriz) {
        if (matriz.length != matriz[0].length) {
            throw new IllegalArgumentException("Error: La matriz no es cuadrada. Filas="
                    + matriz.length + ", Columnas=" + matriz[0].length);
        }
    }

    private static void validarValoresPermitidos(int[][] matriz) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                int valor = matriz[f][c];
                if (valor < 0) {
                    throw new IllegalArgumentException(
                            "Error: Valor negativo encontrado en (" + (f + 1) + "," + (c + 1)
                                    + "): " + valor);
                }
                if (valor > 1) {
                    throw new IllegalArgumentException(
                            "Error: Valor inválido en (" + (f + 1) + "," + (c + 1)
                                    + "). Solo se aceptan 0 y 1 por ahora → encontrado: " + valor);
                }
            }
        }
    }
}
