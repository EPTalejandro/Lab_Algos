
import java.util.Scanner;

public static class DesviacionEstandar{

    //@ requires N > 0;
    //@ requires S != null && S.lenght = N;
    //@ ensures -Long.MAX_VALUE < \result < Long.MAX_VALUE;
    //@ ensures \result == sumaCuadrados/N;
    public static /*@ pure @*/ double calculoDerivacionEstandar(String[] args){

        double suma = 0;

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < suma < Long.MAX_VALUE;
        //@ maintaining suma == (\sum int j; 0 <= j < i; S[j]);
        //@ decreasing N - i;
        for(i = 0, i < N, i++){
            suma += S[i];
        }

        double media = suma / N;
        double sumaCuadrados = 0;

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < sumaCuadrados < Long.MAX_VALUE;
        //@ maintaining sumaCuadrados == (\sum int j; 0 <= j < i; (S[j] - media)*(S[j] - media));
        //@ decreasing N - i;
        for(i = 0, i < N, i++ ){
            sumaCuadrados += Math.pow((S[i] - media), 2);
        }

        double derivacionEstandar = Math.sqrt(sumaCuadrados / N);

        return derivacionEstandar;
    }

    public static /*@ pure @*/ double main(String[] args){

        Scanner scanner = new scanner(System.in);

        do{
            System.out.print("Ingrese la cantidad de números (mínimo 1): ");
            int N = scanner.nextInt();
            if (N <= 0){
                System.out.println("La cantidad debe ser mayor a 0");
            }
        }while(N <= 0);

        int[] S = new int[N];

        System.out.println("Ingrese los numeros");
        for(int i = 0 ; i < N; i++){
            E = i + 1;
            System.out.print("["+E+"]. ");
            S[i] = scanner.nextInt();
        }

        double resultado = calculoDerivacionEstandar(S, N);
        System.out.print("La desviación estandar viene dada por ", resultado);
    }
}