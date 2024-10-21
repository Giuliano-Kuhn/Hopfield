package com.mycompany.hopfield;

import java.util.Arrays;

public class Hopfield {
    
    static int[][] entr1 = {                           //circulo al medio
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    
    static int[][] entr2 = {                           //circulo a la esquina superior izquierda
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    
    
    
    static int[][] entr3 = {                       //circulo abajo
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0}
        };
        
        
        static int[] entr1V;
        static int[] entr2V;
        static int[] entr3V;
        static int[] prueba;
        
        //static int[] entr1T;
        //static int[] entr2T;
        //static int[] entr3T;
        
        static int[][] entr1M;
        static int[][] entr2M;
        static int[][] entr3M;
        
        static int[][] MatrizS;
        
        
        
        static int[][] pruebaMatriz = {                       //
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

    public static void main(String[] args) {
        
        entr1V = Calculos.matrizAVector(entr1);
        entr2V = Calculos.matrizAVector(entr2);
        entr3V = Calculos.matrizAVector(entr3);
        prueba = Calculos.matrizAVector(pruebaMatriz);
        int[] vectorR = new int[prueba.length];
        int[][] Matriz_aux = new int[10][10];
         
        entr1M = Calculos.multiplicarPorTranspuesta(entr1V);
        entr2M = Calculos.multiplicarPorTranspuesta(entr2V);
        entr3M = Calculos.multiplicarPorTranspuesta(entr3V);

        
        //entr1M = Calculos.Multiplicar_Matriz(entr1, entr1T);
        //entr2M = Calculos.Multiplicar_Matriz(entr2, entr2T);
        //entr3M = Calculos.Multiplicar_Matriz(entr3, entr3T);
        
        MatrizS = Calculos.Sumar_Matrices(entr1M, entr2M);
        MatrizS = Calculos.Sumar_Matrices(MatrizS, entr3M);

        
        System.out.println("EMPIEZA EL PROCESO DE RECONOCER EL CIRCULO");
        boolean ident = false;
        do {
        
        vectorR = Calculos.Multiplicar_Matriz(prueba, MatrizS);
        
        System.out.println("----------------------------------------");    
        Calculos.imprimirVectorComoMatriz(prueba);      
        System.out.println("----------------------------------------");  
        
        System.out.println("----------------------------------------");    
        Calculos.imprimirVectorComoMatriz(vectorR);      
        System.out.println("----------------------------------------");  
        
        
        vectorR = Calculos.Aplicar_FunsionDeActivacion(vectorR);
        System.out.println("----------------------------------------");
        
        Calculos.imprimirVectorComoMatriz(vectorR);
        
        System.out.println("----------------------------------------");  
        
       
        if (Arrays.equals(prueba, vectorR)) {
            System.out.println("PATRON ENCONTRADO");
            ident = false;
            
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
            System.out.println("----------------------------------------");
            Calculos.imprimirVectorComoMatriz(prueba);
            System.out.println("----------------------------------------");
        }else{
            System.out.println("PATRON NO ENCONTRADO");
            prueba = vectorR;
            ident = true;
        }
        
        } while (ident);
        
        
       Matriz_aux = Calculos.vector_A_Matrix(prueba);
        Calculos.Encontrar_Centro(Matriz_aux);
        
        
    }
}
