public class Utilidades {

    /*public static int[] diferenciaSimetricaConjuntos(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        
        for (int i = 0; i < a.length; i++){
            if (c[i] != a[i] && !isIn(a[i], b)){
                c[i] = a[i];
            }
        }
        return c;
    }*/

    public static boolean isIn(int k, int[] b){
        //@ maintaining 0 <= i <= b.length;
        //@ decreases b.length - i;
        for (int i = 0; i < b.length; i++){
            if (k == b[i]){
                return true;
            }
        }
        return false;
    }

    /*@ requires matriz.length > 0 && matriz[0]length > 0;
      @ ensures \result.length == matriz[0].length && 
      @         \result[0].length == matriz.length && 
      @         (\forall int i,j; 0 <= i && i < \result.lengt && 0 <= j && j < \result[0].length;
      @            \result[i][j] == matriz[j][i]);
      @*/
    public static double[][] traspuestaMatriz(double[][] matriz){
        double[][] traspuesta = new double[matriz[0].length][matriz.length];
        
        /*@ maintaining 0 <= i <= matriz.length;
          @ maintaining (\forall int j, k; 
          @                 0 <= j && j < i && 0 <= k && k < matriz[0].length;
          @              traspuesta[k][j] == matriz[j][k]);
          @ decreases matriz.length - i;
          @*/
        for (int i = 0; i < matriz.length; i++){
            /*@ maintaining 0 <= j <= matriz[0].length;
              @ maintaining (\forall int k; 
              @                 0 <= k && k < j;
              @              traspuesta[k][i] == matriz[i][k]);
              @ decreases matriz.[0].length - j;
              @*/
            for (int j = 0; j < matriz[0].length; j++){
                traspuesta[j][i] = matriz [i][j];
            }
        }
        return traspuesta;
    }

    /*@ requires (\forall int i,j; 0 <= i && i < a.length && 0 <= j && j < a.length; i != j <==> a[i] != a[j]);
      @ requires (\forall int i,j; 0 <= i && i < b.length && 0 <= j && j < b.length; i != j <==> b[i] != b[j]);
      @ ensures (\forall int i; 0 <= i && i < a.length; (\exist int j; 0 <= j && j < b.length; a[i] == b[j]));
      @*/
    public static boolean esSubconjunto(int[] a, int[] b){
        if(a.length > b.length) return false;

        //@ maintaining 0 <= i <= a.length;
        //@ decreases a.length - i;
        for(int i = 0; i < a.length; i++){
            if(!isIn(a[i], b)){
                return false;
            }
        }
        return true;
    }

      /*@ requires a.length > 0;
        @ assignable a[∗];
        @ ensures (\forall int i ; 1 <= i && i < a.length; a[i] == \old(a[i − 1])) &&
        @         a[0] == \old(a[a.length − 1]);
        @*/
    public static void rotarArreglo(){
        if (a.length == 0) return;
        int ultimo = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i-1];
        }
        a[0] = ultimo;
    }

    public static void particionMenoresMayores(){

    }

    public static void main(String[] args){

        /*int[] a = {1,2,3};
        int[] b = {3,4,5};
        diferenciaSimetricaConjuntos(a,b);*/

        double[][] matriz = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        traspuestaMatriz(matriz);

        int[] tata = {1,2,4};
        int[] titi = {1,2,3};
        System.out.println(esSubconjunto(tato, tito));
    }
}
