package utils;
/**
 * Clase utilitaria para operaciones relacionadas con grafos.
 * @author Jaime Landázuri
 */

public class Util {

    /**
     * Determina si un grafo representado por una matriz de adyacencia es dirigido.
     *
     * @param matrix     Matriz de adyacencia del grafo.
     * @param nVertices  Número de vértices en el grafo.
     * @return true si el grafo es dirigido, false si es no dirigido.
     */
    public static boolean isDirected(int[][] matrix, int nVertices) {
        for (int i = 0; i < nVertices; i++) {
            for (int j = i + 1; j < nVertices; j++) { // recorremos el triangulo superior
                //(ida != vuelta) -> es dirigido
                if (matrix[i][j] != matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
