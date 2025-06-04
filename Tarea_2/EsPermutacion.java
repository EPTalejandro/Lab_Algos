
import java.util.ArrayList;

public class EsPermutacion{

    /*@ 
      @ requires S1.length > 0 && S2.length > 0;
      @ requires S1.length == S2.length;
      @ ensures \result == (\forall int z;
                (\num_of int i; 0 <= i && i < S1.length; S1[i] == z) == (\num_of int i; 0 <= i && i < S2.length; S2[i] == z));
    @*/

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

        /*@ 
          @ requires S > 0;
          @ ensures (\result == (\count int i; 0 <= i && i < S.length; S[i] == E);
        @*/

    public static int cuentaElementoPosicion(int[] S, int E){
        int r = 0;
        
        /*@
          @ maintaining 0 <= i && i <= S.length;
          @ maintaining r == (\count int j; 0 <= j && j < S.length; S[j] == E);
          @ decreasing S.length - i;
        @*/

        for(int i = 0; i < S.length; i++){
            if(S[i] == E){
                r++;
            }
        }

        return r;
    }
    
}
