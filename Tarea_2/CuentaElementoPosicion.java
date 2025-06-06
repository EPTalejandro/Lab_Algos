public class CuentaElementoPosicion {

    /*@
        requires secuencia != null && secuencia.length > 0;
        requires K < secuencia.length;
        ensures \result == (\sum int i; 0 <= i && i < secuencia.length && secuencia[i] == secuencia[K]; 1);
    @*/
    public static int cuentaElementoPosicion(int[] secuencia, int K){

        int E = 0;

        /*@
            maintaining 0 <= i && i <= secuencia.length;
            maintaining E == (\sum int j; 0 <= j && j < i && secuencia[j] == secuencia[K]; 1);
            maintaining 0 <= E && E <= i;
            decreasing secuencia.length - i;
        @*/
        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E = E + 1;
            }
        }
        return E;
    }
}
