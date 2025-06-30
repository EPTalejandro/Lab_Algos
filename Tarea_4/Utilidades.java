public class Utilidades {

    public static int[] diferenciaSimetricaConjuntos(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        
        for (int i = 0; i < a.length; i++){
            if (c[i] != a[i] && !isIn(a[i], b)){
                c[i] = a[i];
            }
        }
        return c;
    }

    public static boolean isIn(int k, int[] b){
        for (int i = 0; i < b.length; i++){
            if (k == b[i]){
                return true;
            }
        }
        return false;
    }

    /*@ requieres matriz.length > 0 && matriz[0]length > 0;
      @ ensures \result.length == matriz[0].length && 
      @         \result[0].length == matriz.length && 
      @         (\forall int i,j; 0 <= i && i < \result.lengt && 0 <= j && j < \result[0].length;
      @            \result[i][j] == matriz[j][i]);
      @*/
    public static double[][] traspuestaMatriz(double[][] matriz){
        double[][] traspuesta = new double[matriz[0].length][matriz.length];
        
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++){
                traspuesta[j][i] = matriz [i][j];
            }
        }
        return traspuesta;
    }

    /*public static boolean esSubconjunto(){

    }*/

    public static void rotarArreglo(){

    }

    public static void particionMenoresMayores(){

    }

    public static void main(String[] args){

        int[] a = {1,2,3};
        int[] b = {3,4,5};
        diferenciaSimetricaConjuntos(a,b);
    }
}
