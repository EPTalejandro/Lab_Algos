public class EsMatrizDiagonal {

    //@ requires matriz != null;
    //@ requires matriz.length >= 4;
    //@ ensures \result == (\forall int i, j; 
    //@                    i != j ==> matrizDiagonal[i][j] == 0);

    public static /*@ pure @*/ boolean esMatrizDiagonal(double[] matriz) {

        double[][] matrizDiagonal;
        boolean esDiagonal = true;
        int N = 0;
        
        if(Math.sqrt(matriz.length) != Math.floor(Math.sqrt(matriz.length))){
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }

        int nfilas_columnas = (int) Math.sqrt(matriz.length);
        matrizDiagonal = new double[nfilas_columnas][nfilas_columnas];

        //@ maintaining 0 <= i < nfilas_columnas;
        //@ maintaining 0 <= j < nfilas_columnas;
        //@ decreasing matriz.length - N;
        for (int i = 0; i < nfilas_columnas; i++) {
            for (int j = 0; j < nfilas_columnas; j++) {
                matrizDiagonal[i][j] = matriz[N];
                N = N + 1;
            }
        }

        //@ maintaining 0 <= i < nfilas_columnas;
        //@ maintaining 0 <= j < nfilas_columnas;
        //@ decreasing matriz.length - N;
        for(int i=0;i<nfilas_columnas;i++){
            for(int j=0;j<nfilas_columnas;j++){
                if(j!=i && matrizDiagonal[i][j] != 0){
                    esDiagonal = false;
                    break;
                }
            }
        }
        return esDiagonal;
    }
}
