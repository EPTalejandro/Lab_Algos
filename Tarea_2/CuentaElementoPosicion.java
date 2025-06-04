public class CuentaElementoPosicion {

    //@ requires secuencia != null;
    //@ requires k < secuencia.length && secuencia.lenght > 0;
    //@ ensures \result == (\sum int i; 0 <= i < secuencia.length && secuencia[i] == secuencia[k]; 1);

    public static int cuentaElementoPosicion(int[] secuencia, int K){

        int E = 0;

        //@ maintaining 0 <= i < secuencia.lenght;
        //@ maintaining E == (\sum int i; 0 <= i < secuencia.length && secuencia[i] == secuencia[k]; 1) && E < Integer.MAX_VALUE;
        //@ decreasing secuencia.length - i;
        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E = E + 1;
            }
        }

        return E;
    }
}
