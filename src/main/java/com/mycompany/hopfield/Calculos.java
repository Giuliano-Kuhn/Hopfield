
package com.mycompany.hopfield;

public class Calculos {
    
    public static int[][] multiplicarPorTranspuesta(int[] vector) {
        int n = vector.length;
        int[][] matrizResultado = new int[n][n];

        // Multiplicar cada elemento del vector por los elementos de su transpuesta
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizResultado[i][j] = vector[i] * vector[j];
            }
        }

        return matrizResultado;
    }
    
    
    
    public static int[] Multiplicar_Matriz(int[] vector, int[][] matriz){
        int n = vector.length; // Número de elementos en el vector
        int m = matriz[0].length; // Número de columnas en la matriz

        int[] resultado = new int[m];

        // Multiplicar el vector por la matriz
        for (int j = 0; j < m; j++) {
            int suma = 0;
            for (int i = 0; i < n; i++) {
                suma += vector[i] * matriz[i][j];
            }
            resultado[j] = suma;
        }

        return resultado;  
    }
    
    public static int[][] Sumar_Matrices(int[][] matriz1, int[][] matriz2) {
        int n = matriz1.length;
        int[][] matriz_S = new int [n][n];
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz_S[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
            
        for (int i = 0; i < n; i++) {
            matriz_S[i][i] = 0;
        }
            
        return matriz_S;
    }
    
    
    public static int[] Aplicar_FunsionDeActivacion(int[] vectorR ) {
        int n = vectorR.length;
        int[] vectorRR = new int[n];
        for (int i = 0; i < n; i++) {
                vectorRR[i] = Funsion_De_Activacion(vectorR[i]);
            
            
        }
        return vectorRR;
    }
    
    public static int Funsion_De_Activacion(int numero) {
        return numero >= 10 ? 1 : 0; // Función escalonada
    }
    
    public static void printVector(int[] vector) {
      System.out.println("Contenido del vector:");
        for (int i = 0; i < vector.length; i++) {
        System.out.print(vector[i] + " ");
        }
    }
    
    
    
     public static void printMatrix(int[][] matrix) {
        // Recorrer filas
        for (int[] row : matrix) {
            // Recorrer columnas
            for (int value : row) {
                System.out.print(value + "\t"); // Usar tabulaciones para un mejor formato
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
     
     
    public static int[] matrizAVector(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[] vector = new int[filas * columnas];

        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                vector[index++] = matriz[i][j];
            }
        }

        return vector;
    }
    
        public static void imprimirVectorComoMatriz(int[] vector) {
        // Verificamos que el tamaño del vector sea compatible con las dimensiones de la matriz
        int filas = 10;
        int columnas = 10;
        if (vector.length != filas * columnas) {
            System.out.println("El tamaño del vector no coincide con las dimensiones de la matriz.");
            return;
        }

        System.out.println("Vector impreso como una matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Calculamos el índice del vector basado en la posición de la matriz
                int index = i * columnas + j;
                System.out.print(vector[index] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
        
    public static int[][] vector_A_Matrix(int[] vector) {
        int filas = 10;
        int columnas = 10;

        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = vector[i * columnas + j]; // Calcular el índice del vector
            }
        }

        return matriz;
    }
    
    public static void Encontrar_Centro(int[][] matrix) {
        int sumX = 0;
        int sumY = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    sumX += j;  // Sumar coordenada X
                    sumY += i;  // Sumar coordenada Y
                    count++;    // Contar los 1s
                }
            }
        }

        if (count > 0) {
            int centroCX = 5;
            int centroCY = 4;
            // Calcular el promedio de las coordenadas
            int centroX = sumX / count;
            int centroY = sumY / count;


            System.out.println("El centro del círculo está en: (" + centroX + ", " + centroY + ")");
            if (centroCX == centroX && centroCY == centroY) {
                 System.out.println("El Circulo está centrado");
            }else{
                System.out.println("El Circulo está desentrado");
                System.out.println("El Centro es en las coordenadas X=5 y Y=4");
            }
            
        } else {
            System.out.println("No se encontro el circulo.");
        }
    }
    
    
    
    
}    
        
    
    
