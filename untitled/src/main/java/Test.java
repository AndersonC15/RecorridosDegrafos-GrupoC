import io.ValidadorMatriz;
import structures.Graph;

import java.io.IOException;

/**
 * Clase de prueba para cargar una matriz desde un archivo y crear un grafo dirigido
 */

public class Test {
    public static void main(String[] args) {
        try{
            //Uso la clase de anderson (LectorMatriz) para cargar la matriz (Arreglo i*j) desde un archivo
            int[][] dirigido = io.LectorMatriz.cargar("untitled/src/main/resources/g_dirigido_matriz.txt");
            ValidadorMatriz.validar(dirigido);
            Graph graph = new Graph(dirigido);
            System.out.println("Grafo dirigido:");
            System.out.println(graph);
        } catch (IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
