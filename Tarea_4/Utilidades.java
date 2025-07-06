import java.util.ArrayList;

public class Utilidades {

    /*@ requires a != null && a.length > 0;
      @ requires (\forall int i, j; 0 <= i && i < a.length && 0 <= j && j < a.length && i != j; a[i] != a[j]);
      @ requires b != null && b.length > 0;
      @ requires (\forall int i, j; 0 <= i && i < b.length && 0 <= j && j < b.length && i != j; b[i] != b[j]);
      @ requires a.length + b.length < Integer.MAX_VALUE;
      @ ensures (\forall int i; 0 <= i && i < \result.length; 
      @             (\exists int j; 0 <= j && j < a.length; \result[i] == a[j] && (\forall int k; 0 <= k && k < b.length; \result[i] != b[k])) ||
      @             (\exists int j; 0 <= j && j < b.length; \result[i] == b[j] && (\forall int k; 0 <= k && k < a.length; \result[i] != a[k])));
      @*/
    public /*@ pure @*/ static int[] diferenciaSimetricaConjuntos(int[] a, int[] b){
        ArrayList<Integer> numerosDifSim = new ArrayList<>(a.length + b.length);
        /*@ maintaining 0 <= i <= a.length;
          @ decreases a.length - i;
          @*/
        for (int i = 0; i < a.length; i++){
            if (!isIn(a[i], b)){
                numerosDifSim.add(a[i]);
            }
        }
        /*@ maintaining 0 <= i <= b.length;
          @ decreases b.length - i;
          @*/
        for (int i = 0; i < b.length; i++){
            if (!isIn(b[i], a)){
                numerosDifSim.add(b[i]);
            }
        }
        int[] c = new int[numerosDifSim.size()];
        /*@ maintaining 0 <= i <= numerosDifSim.size();
          @ maintaining (\forall int j; 0 <= j && j < i; c[j] == numerosDifSim.get(j));
          @ decreases numerosDifSim.size() - i;
          @*/
        for(int i = 0; i < numerosDifSim.size(); i++){
            c[i] = numerosDifSim.get(i);
        }
        return c;
    }

    //@ requires b != null && b.length > 0;
    //@ ensures \result <==> (\exists int i; 0 <= i && i < b.length; k == b[i]);
    public /*@ pure @*/ static boolean isIn(int k, int[] b){
        //@ maintaining 0 <= i <= b.length;
        //@ maintaining (\forall int j; 0 <= j && j < i; k != b[j]);
        //@ decreases b.length - i;
        for (int i = 0; i < b.length; i++){
            if (k == b[i]){
                return true;
            }
        }
        return false;
    }

    /*@ requires matriz.length > 0 && matriz[0].length > 0;
      @ ensures \result.length == matriz[0].length && 
      @         \result[0].length == matriz.length && 
      @         (\forall int i,j; 0 <= i && i < \result.length && 0 <= j && j < \result[0].length;
      @            \result[i][j] == matriz[j][i]);
      @*/
    public /*@ pure @*/ static double[][] traspuestaMatriz(double[][] matriz){
        double[][] traspuesta = new double[matriz[0].length][matriz.length];
        
        /*@ maintaining 0 <= p <= matriz.length;
          @ maintaining (\forall int j, k; 
          @                 0 <= j && j < p && 0 <= k && k < matriz[0].length;
          @              traspuesta[k][j] == matriz[j][k]);
          @ decreases matriz.length - p;
          @*/
        for (int p = 0; p < matriz.length; p++){
            /*@ maintaining 0 <= q <= matriz[0].length;
              @ maintaining (\forall int k; 
              @                 0 <= k && k < q;
              @              traspuesta[k][p] == matriz[p][k]);
              @ decreases matriz[0].length - q;
              @*/
            for (int q = 0; q < matriz[0].length; q++){
                traspuesta[q][p] = matriz [p][q];
            }
        }
        return traspuesta;
    }

    /*@ requires (\forall int i,j; 0 <= i && i < a.length && 0 <= j && j < a.length; i != j <==> a[i] != a[j]);
      @ requires (\forall int i,j; 0 <= i && i < b.length && 0 <= j && j < b.length; i != j <==> b[i] != b[j]);
      @ ensures \result <==> (\forall int i; 0 <= i && i < a.length; (\exists int j; 0 <= j && j < b.length; a[i] == b[j]));
      @*/
    public /*@ pure @*/ static boolean esSubconjunto(int[] a, int[] b){
        if(a.length > b.length) {
            //@ assert (\exists int i; 0 <= i && i < a.length; (\forall int j; 0 <= j && j < b.length; a[i] != b[j]));
            return false;
        }
        //@ maintaining 0 <= i <= a.length;
        //@ maintaining (\forall int j; 0 <= j && j < i; (\exists int k; 0 <= k && k < b.length; a[j] == b[k]));
        //@ decreases a.length - i;
        for(int i = 0; i < a.length; i++){
            if(!isIn(a[i], b)){
                return false;
            }
        }
        return true;
    }

    /*@ requires a.length > 0;
      @ assignable a[*];
      @ ensures (\forall int i ; 1 <= i && i < a.length; a[i] == \old(a[i - 1])) &&
      @         a[0] == \old(a[a.length - 1]);
      @*/
    public static void rotarArreglo(int[] a){
        if (a.length == 0) return;
        //@ ghost int[] old = a.clone();
        int ultimo = a[a.length - 1];
        /*@ maintaining 0 <= i < a.length;
          @ maintaining (\forall int j; i < j && j < a.length; a[j] == old[j - 1]);
          @ decreases i;
          @*/
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i-1];
        }
        a[0] = ultimo;
    }
    
    /*@ requires a.length > 0;
      @ assignable a[*];
      @ ensures (\exists int k; 0 <= k && k <= a.length; 
      @             (\forall int i; 0 <= i && i < k; a[i] <= x) && 
      @             (\forall int i; k <= i && i < a.length; a[i] > x));
      @         (\forall int z; 0 <= z && z < a.length;
      @             (\num_of int i; 0 <= i && i < a.length; a[i] == a[z]) ==
      @             (\num_of int i; 0 <= i && i < \old(a.length); \old(a[i]) == a[z]));
      @*/
    public static void particionMenoresMayores(int[] a, int x){
        int izquierda = 0;
        int derecha = a.length - 1;
        /*@ maintaining 0 <= izquierda && izquierda <= derecha + 1 && derecha < a.length;
          @ maintaining (\forall int j; 0 <= j && j < izquierda; a[j] <= x);
          @ maintaining (\forall int k; derecha <= k && k < a.length; a[k] > x);
          @ decreases derecha - izquierda + 1;
          @*/
        while(izquierda <= derecha){
            if(a[izquierda] <= x){
                izquierda = izquierda + 1;
            }
            else{
                int temporal = a[izquierda];
                a[izquierda] = a[derecha];
                a[derecha] = temporal;
                derecha = derecha -1;
            }
        }
    }
}
