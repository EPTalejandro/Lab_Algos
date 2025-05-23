import java.util.Scanner;

public class TipoTrianguloPorLado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lado1, lado2, lado3;

        System.out.print("Ingrese el primer lado: ");
        lado1 = scanner.nextInt();
        System.out.print("Ingrese el segundo lado: ");
        lado2 = scanner.nextInt();
        System.out.print("Ingrese el tercer lado: ");
        lado3 = scanner.nextInt();

        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("1");
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            System.out.println("2");
        } else {
            System.out.println("3");
        }
    }
} 
