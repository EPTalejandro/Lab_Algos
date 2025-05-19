
import java.util.Scanner;

public class EsMatrizDiagonal {

    public static void main(String[] args) {
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
                System .out.print("Elemento ["+i+"]["+j+"]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < nfilas_columnas; i++) {
            System.out.print("| ");
            for (int j = 0; j < nfilas_columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("|\n");
        }
        for(int i=0;i<nfilas_columnas;i++){
            for(int j=0;j<nfilas_columnas;j++){
                if(j!=i && matriz[i][j] != 0){
                    esDiagonal = false;
                    break;
                    }
                }
            }
        System.out.println(esDiagonal);
    }
}