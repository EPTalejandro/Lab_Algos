public class CuentaElementoPosicion {

    //@ requires secuencia != null;
    //@ requires 0 <= k < secuencia.length && secuencia.lenght > 0;
    //@ ensures \result == (\count int i; 0 <= i < secuencia.length ; secuencia[i] == secuencia[k]);
    public static int cuentaElementoPosicion(int[] secuencia, int K){

        int E = 0;

        //@maintaining 0 <= i < secuencia.lenght;
        //@ maintaining E == \count int i; 0 <= i < secuencia.length; secuencia[i] == secuencia[k];
        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E = E + 1;
            }
        }

        return E;
    }
}
