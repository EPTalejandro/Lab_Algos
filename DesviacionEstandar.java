import java.util.Scanner;

public class DesviacionEstandar{

    //@ requires N > 0;
    //@ requires S != null 
    //@ requires S.lenght = N;
    //@ ensures -Long.MAX_VALUE < \result < Long.MAX_VALUE;
    //@ ensures \result == sumaCuadrados/N;
    public static /*@ pure @*/ double main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N;
        int i;

        do{
            System.out.print("Ingrese la cantidad de números (mínimo 1): ");
            N = scanner.nextInt();
            if (N <= 0){
                System.out.println("La cantidad debe ser mayor a 0");
            }
        }while(N <= 0);

        int[] S = new int[N];

        System.out.println("Ingrese los numeros");

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE / N <= S[i] <= Long.MAX_VALUE / N
        //@ decreasing N - i;
        for(i = 0 ; i < N; i++){
            int E = i + 1;
            System.out.print("["+E+"]. ");
            S[i] = scanner.nextInt();
        }

        double suma = 0;

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < suma < Long.MAX_VALUE;
        //@ maintaining suma == (\sum int j; 0 <= j < i; S[j]);
        //@ decreasing N - i;
        for(i = 0; i < N; i++){
            suma += S[i];
        }

        double media = suma / N;
        double sumaCuadrados = 0;

        //@ maintaining 0 <= i <= N;
        //@ maintaining -Long.MAX_VALUE < sumaCuadrados < Long.MAX_VALUE;
        //@ maintaining sumaCuadrados == (\sum int j; 0 <= j < i; (S[j] - media)*(S[j] - media));
        //@ decreasing N - i;
        for(i = 0; i < N; i++){
            sumaCuadrados += Math.pow((S[i] - media), 2);
        }

        double desviacionEstandar = Math.sqrt(sumaCuadrados / N);

        return desviacionEstandar;
    }
}