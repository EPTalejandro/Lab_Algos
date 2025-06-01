public class CuentaElementoPosicion {

    public static int cuentaElementoPosicion(int[] secuencia, int K){

        int E = 0;

        for(int i = 0; i < secuencia.length; i++){
            if(secuencia[i] == secuencia[K]){
                E++;
            }
        }

        return E;
    }
}
