
import java.util.ArrayList;

public class EsPermutacion{

    public static boolean esPermutacion(int[] S1, int[] S2){
        
        ArrayList<Integer> revisado = new ArrayList<>();

        if(S1.length != S2.length){
            return false;
        }

        for(int i = 0; i < S1.length; i++){
            if( !revisado.contains(S1[i]) && cuentaElementoPosicion(S1, S1[i]) == cuentaElementoPosicion(S2, S1[i])){
                revisado.add(S1[i]);
            } else if(revisado.contains(S1[i])){
            } else {
                return false;
            }
        }
        return true;
    }

    public static int cuentaElementoPosicion(int[] S, int E){
        int r = 0;

        for(int i = 0; i < S.length; i++){
            if(S[i] == E){
                r++;
            }
        }

        return r;
    }
}
