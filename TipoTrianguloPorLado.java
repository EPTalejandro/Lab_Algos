import java.util.Scanner;

public class TipoTrianguloPorLado {

    //@ requires lado1 > 0 && lado2 > 0 && lado3 > 0;
    //@ ensures \result == 1 <==> (lado1 == lado2 && lado2 == lado3);
    //@ ensures \result == 2 <==> ((lado1 == lado2 || lado1 == lado3 || lado2 == lado3) && !(lado1 == lado2 && lado2 == lado3));
    //@ ensures \result == 3 <==> (lado1 != lado2 && lado1 != lado3 && lado2 != lado3);

    public static int tipoTriangulo(int lado1, int lado2, int lado3){
        if (lado1 == lado2 && lado2 == lado3){
            return 1;
        } else if (lado1 == lado2 || lado1==lado3 || lado2==lado3) {
            return 2;
        }else {
            return 3;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lado1, lado2, lado3;

        System.out.print("Ingrese el primer lado: ");
        lado1 = scanner.nextInt();
        System.out.print("Ingrese el segundo lado: ");
        lado2 = scanner.nextInt();
        System.out.print("Ingrese el tercer lado: ");
        lado3 = scanner.nextInt();

        int lado = tipoTriangulo(lado1,lado2,lado3);
        System.out.println(lado);
    }
} 