public class PromedioPares {
    
    //@ requires secuencia != null;
    //@ requires (\forall int i; 0 <= i < secuencia.length; secuencia[i] >= 0);
    //@ ensures \result == 0 <==> (\forall int i; 0 <= i < secuencia.length; secuencia[i] % 2 !=0); 
    //@ ensures \result == (\sum int i; 0 <= i < secuencia.length && secuencia[i] % 2 == 0; secuencia[i]) / (\sum int i; 0 <= i < secuencia.length && secuencia[i] % 2 == 0 ; 1);

    public static /*@ pure @*/ int promedioPares (int[] secuencia){

        int suma = 0;
        int pares = 0;
        int promedio = 0;
        
        //@ maintaining 0 <= i && i < secuencia.length;
        //@ maintaining suma == (\sum int j; 0 <= j < i && secuencia[j] % 2 == 0; secuencia[j]);
        //@ maintaining pares == (\sum int j; 0 <= j < i && secuencia[j] % 2 == 0; 1);
        //@ decreasing secuencia.length - i;
        for (int i = 0; i < secuencia.length; i++){
            if (secuencia[i] % 2 == 0){
                suma = suma + secuencia[i];
                pares = pares + 1;
            }
        }
        if (pares >0){
            promedio = suma / pares;
        }
        return promedio;    
    }
}
