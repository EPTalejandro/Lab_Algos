public class CuentaElementoPosicion {

    public static int cuentaElementoPosicion(int[] secuencia, int K){

        //@ requires secuencia != null;
        //@ requieres 0<= k < secuencia.length && secuencia.lenght > 0;

        int E = 0;

        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E++;
            }
        }

        return E;
    }
}
