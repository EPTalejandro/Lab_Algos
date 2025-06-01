public class PromedioPares {
    
    public static double promedioPares (int[] secuencia){

        double suma = 0;
        int pares = 0;

        for (int i = 0; i < secuencia.length; i++){
            if (secuencia[i] % 2 == 0){
                suma = suma + secuencia[i];
                pares++;
            }
        }

        return suma / pares;
    }
}
