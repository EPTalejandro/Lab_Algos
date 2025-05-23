public class DesviacionEstandar{

    //@ requires numeros.length > 0;
    //@ ensures -Long.MAX_VALUE < \result < Long.MAX_VALUE;
    //@ ensures \result == sumaCuadrados/N;
    public static /*@ pure @*/ double calculoDesviacionEstandar(double[] numeros){

        int N = numeros.length;
        int i;
        double suma = 0;
        double media = suma / N;
        double sumaCuadrados = 0;
        
        if(N == 0){
            throw new IllegalArgumentException("La secuencia no puede estar vacía.");
        }
        
        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < suma < Long.MAX_VALUE;
        //@ maintaining suma == (\sum int j; 0 <= j < i; S[j]);
        //@ decreasing N - i;
        for(i = 0; i < N; i++){
            suma += numeros[i];
        }

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < sumaCuadrados < Long.MAX_VALUE;
        //@ maintaining sumaCuadrados == (\sum int j; 0 <= j < i; (S[j] - media)*(S[j] - media));
        //@ decreasing N - i;
        for(i = 0; i < N; i++){
            sumaCuadrados += Math.pow((numeros[i] - media), 2);
        }

        double desviacionEstandar = Math.sqrt(sumaCuadrados / N);

        return desviacionEstandar;
    }
}
