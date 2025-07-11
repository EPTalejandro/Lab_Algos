import java.util.Arrays;
import java.util.Scanner;

public class Logica{

    static int[][] tablero = new int[9][9];

    // 1 cuadrado verde 2 bola roja 3 bola azul 4 bola amarilla 5 bola blanca 6 bola naranja 7 bola morada
    static int[] elementos = new int[]{1,2,3,4,5,6,7};

    static int puntaje = 0;

    public static void iniciarTablero(int[] jugada){
        for(int i=0;i<3;i++){
            int a = (int)(Math.random() * 9);
            int b = (int)(Math.random() * 9);
            if(Logica.tablero[a][b] == 0){
                Logica.tablero[a][b] = jugada[i];
            }
            else{
                i = i-1;
            }
            
        }
    }

    public static boolean jugadaEsValida(int f,int c, int[][] posiciones){
        for(int i=-1;i<2;i++){
            for( int j=-1;j<2;j++){
                if( i == 0 && j == 0 ){continue;}
                if(f+i >= 0 && c+j >= 0 && f+i < 9 && c+j < 9){
                    if(posiciones[f+i][c+j]==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void siguienteJugada(){
        int[][] posiciones = Logica.tablero;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la fila del objeto que quiere mover");
        int f = entrada.nextInt() - 1;
        System.out.println("ingrese la columna del objeto que quiere mover");
        int c = entrada.nextInt() - 1;
        // Si quire mover un elemento vacio reinicia la funcion
        if(posiciones[f][c] == 0){
            System.out.println("la posicion que desea mover esta vacia");
            siguienteJugada();
            return;
        }
        //Si el elemento que quiere mover es valido continua con las siguientes comprobaciones
        if (jugadaEsValida(f, c, posiciones)){
            System.out.println("ingrese la fila a donde desea moverlo");
            int fD = entrada.nextInt() - 1;
            System.out.println("ingrese la columna a donde desea moverlo");
            int cD = entrada.nextInt() - 1;
            if(posiciones[fD][cD] == 0){
                posiciones[fD][cD] = posiciones[f][c];
                posiciones[f][c] = 0;
            }
            else{
                System.out.println("la posicion a donde desea moverlo ya esta ocupado escoja otra");
                siguienteJugada();
            }
        }
        //si el movimiento deseado no es valido solicita otro movimiento 
        else{
            System.out.println("No puedes mover el elemento que seleccionaste");
            siguienteJugada();
        }
    }

    // imprime el estado actual del tablero con una ligera estilizacion grafica
    public static void imprimirTablero(int[][] matriz) {
        System.out.print("    1 2 3 4 5 6 7 8 9");
        System.out.println();
        System.out.print("    _ _ _ _ _ _ _ _ _");
        System.out.println();
        for(int i = 0; i < matriz.length; i++) {
            System.out.print((i+1)+" | ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Si hay alguna casilla no vacia significa que el juego no ha terminado 
    public static boolean terminoElJuego(){
        int[][] posiciones = Logica.tablero;
        for(int i=0;i<9;i++){
            for (int j = 0; j < 9; j++) {
                if(posiciones[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    // Retorna los siguientes elementos a ser puestos en el tablero 
    public static int[] obtenerSiguientesElementos(){
        int[] proxima_jugada = new int[3];
        for(int i=0; i<3;i++){
            int a = (int)(Math.random() * 7);
            proxima_jugada[i] = elementos[a];
        }
        return proxima_jugada;
    }

    public static void main(String[] args) {
        boolean juego = true;
        iniciarTablero(obtenerSiguientesElementos());
        while (juego) { 
            if(terminoElJuego()==true){
                juego = false;
            }
            int[] proxima = obtenerSiguientesElementos();
            imprimirTablero(tablero);
            System.out.println("los siguientes elementos son "+ Arrays.toString(proxima));
            siguienteJugada();
            iniciarTablero(proxima);
        }
    }
}