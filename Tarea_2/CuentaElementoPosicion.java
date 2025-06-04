public class CuentaElementoPosicion {

    public static int cuentaElementoPosicion(int[] secuencia, int K){

        //@ requires secuencia != null;
        //@ requires 0 <= k < secuencia.length && secuencia.lenght > 0;
        //@ ensures \result == \count int i; 0 <= i < secuencia.length ; secuencia[i] == secuencia[k];
        int E = 0;

        //@maintaining 0 <= i < secuencia.lenght;
        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E++;
            }
        }

        return E;
    }
}
