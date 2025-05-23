
import java.util.Scanner;

public class EsMatrizDiagonal {

    public static boolean main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz;
        int  nfilas_columnas;
        boolean esDiagonal = true;
        
        do {
            System.out.print("Ingrese el número de filas y columnas (mínimo 2): ");
            nfilas_columnas = scanner.nextInt();
            if (nfilas_columnas < 2) {
                System.out.println("El número debe ser mayor o igual a 2. Intente de nuevo.");
            }
        } while (nfilas_columnas < 2);

        matriz = new int[nfilas_columnas][nfilas_columnas];
        System.out.println("Introduzca los elementos de la matriz:");
        
        for (int i = 0; i < nfilas_columnas; i++) {
            for (int j = 0; j < nfilas_columnas; j++) {
                int F = i + 1;
                int C = j + 1;
                System .out.print("Elemento ["+F+"]["+C+"]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 0; i < nfilas_columnas; i++) {
            System.out.print("| ");
            for (int j = 0; j < nfilas_columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        
        for(int i=0;i<nfilas_columnas;i++){
            for(int j=0;j<nfilas_columnas;j++){
                if(j!=i && matriz[i][j] != 0){
                    esDiagonal = false;
                    break;
                }
            }
        }
        
        return esDiagonal;
    }
}
