package structures;

import utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un grafo utilizando una lista de adyacencia y una matriz de adyacencia.
 * Permite determinar si el grafo es dirigido o no basado en la matriz proporcionada.
 * Además, proporciona métodos para agregar aristas y obtener información sobre el grafo.
 * @author Jaime Landázuri
 */

public class Graph {
    private final int nVertices;
    private final boolean isDirected;
    private final List<List<Integer>> adjList;
    private final int[][] matrix;
    public Graph(int[][] matrix) {
        this.matrix = matrix;
        // Número de vértices basado en el tamaño de la matriz
        this.nVertices = matrix.length;

        // Determinación de si el grafo es dirigido utilizando la función utilitaria
        this.isDirected = Util.isDirected(matrix, nVertices);

        // Inicialización de la lista de adyacencia
        this.adjList = new ArrayList<>(nVertices);

        // Creación de listas vacías para cada vértice
        for (int i = 0; i<nVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Población de la lista de adyacencia basada en la matriz
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                // Si hay conexión
                if (matrix[i][j] != 0) {
                    // si es dirigido agregamos todo
                    // si no, solo agregamos si j >= i (triangulo superior)
                    if (isDirected() || j >= i) {
                        addEdge(i, j);
                    }
                }
            }
        }
    }

    /**
     * Agrega una arista desde el vértice 'from' al vértice 'to'.
     * Si el grafo no es dirigido, también agrega la arista inversa.
     *
     * @param from Vértice de origen.
     * @param to   Vértice de destino.
     */
    public void addEdge(int from, int to) {
        if(from<0 || from>=nVertices || to<0 || to>=nVertices) return;
        adjList.get(from).add(to);
        if(!isDirected) {
            adjList.get(to).add(from);
        }
    }

    public int getnVertices() { return nVertices; }
    public boolean isDirected() { return isDirected; }
    public List<List<Integer>> getAdjList() { return adjList; }
    public int[][] getMatrix() { return matrix; }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph (").append(isDirected ? "Directed" : "Undirected").append(") with ").append(nVertices).append(" vertices:\n");
        for (int i = 0; i < nVertices; i++) {
            sb.append(i).append(": ");
            for (Integer neighbor : adjList.get(i)) {
                sb.append(neighbor).append("->");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
