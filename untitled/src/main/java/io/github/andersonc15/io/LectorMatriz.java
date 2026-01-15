package io.github.andersonc15.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase encargada de leer una matriz desde un archivo utilizando Streams
 */
public class LectorMatriz {

    public static int[][] cargar(String archivo) throws IOException {
        List<String> lineas = Files.lines(Path.of(archivo))
                .map(String::trim)
                .filter(l -> !l.isEmpty())   // elimina líneas en blanco
                .toList();

        // Validamos que el archivo no este vacío
        if (lineas.isEmpty()) {
            throw new IllegalArgumentException("Error: El archivo está vacío o no tiene datos válidos.");
        }

        // Convertimos cada línea a arreglo de enteros
        int filas = lineas.size();
        int[][] matriz = new int[filas][];

        for (int i = 0; i < filas; i++) {
            String[] partes = lineas.get(i).split("\\s+");

            int[] filaActual = new int[partes.length];
            for (int j = 0; j < partes.length; j++) {
                try {
                    filaActual[j] = Integer.parseInt(partes[j]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Error: Valor no numérico encontrado en fila "
                            + (i + 1) + ", columna " + (j + 1) + ": \"" + partes[j] + "\"");
                }
            }
            matriz[i] = filaActual;
        }
        return matriz;
    }
}
