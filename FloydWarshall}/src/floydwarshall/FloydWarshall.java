/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floydwarshall;

/**
 *
 * @author jcsaieh
 */
public class FloydWarshall {

    /**
     * @param args the command line arguments
     */
    static void floyd_Warshall(int grafo[][]) {
        // TODO code application logic here
        int n = grafo.length;
        int distancia[][] = getMatrix(0, grafo);
        int caminos[][] = getMatrix(1, grafo);
        int tmp;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp = distancia[i][k] + distancia[k][j];
                    if(tmp<distancia[i][j])
                    {
                        distancia[i][j] = tmp;
                        caminos[i][j] = k;
                    }
                }
            }
        }
        print("Matriz de distancia inicial: ", distancia);
        print("Matriz de caminos inicial: ", caminos);
    }
    
    static void print(String mensaje, int M[][]){
        System.out.println(mensaje);
        int n = M.length;
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++) {
                System.out.println(M[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static int[][] getMatrix(int tipo, int grafo[][])
    {
        int n = grafo.length;
        int M[][] = new int[n][n];
        
        if(tipo==1){
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    M[i][j] = j;
                }
            }
        }else{
            int INF = 999;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i!=j && M[i][j] == 0) {
                        M[i][j] = INF;
                    }else {
                        M[i][j] = grafo[i][j];
                    }
                }
            }
        }
        
        
        
        return M;
    }
    
    public static void main(String[] args) {
        int grafo[][] = 
        {
            {0, 0, 0, 2, 0},
            {3, 0, 0, 0, 0},
            {9, 0, 0, 5, 8},
            {0, 1 ,0, 0, 0},
            {1, 0, 7, 0, 4}
            
        
        };
        
    }
}
