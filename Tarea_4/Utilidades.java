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

/*    public static double[][] traspuestaMatriz(){

    }

    public static boolean esSubconjunto(){

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
