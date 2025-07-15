import java.util.Arrays;
import java.util.Scanner;

public class Logica{
    static Graficos.Celd[][] tablero = Graficos.getTablero();
    // el 0 representa cuadros vacios
    // 1 cuadrado verde 2 bola roja 3 bola azul 4 bola amarilla 5 bola blanca 6 bola naranja 7 bola morada
    static int[] elementos = new int[]{1,2,3,4,5,6,7};
    static int[][] direcciones = {{0,1},{1,0},{1,1},{1,-1}}; // horizontal, vertical, diagonal derecha y diagonal izquierda
    // Tablita de puntos
    static int[] puntos = {0,0,0,0,5,10,12,18,40}; // 4 objetos valen 5 puntos, 5 objetos 10 puntos, ... , mayor o igual que 8 son 40


    static int puntaje = 0;
    // funcion posiblemente no necesaria 
    public static void iniciarTablero(int[] jugada){
        for(int i=0;i<3;i++){
            int a = (int)(Math.random() * 9);
            int b = (int)(Math.random() * 9);
            if(tablero[a][b].getValor() == 0){
                tablero[a][b].setValor(jugada[i]);
            }
            else{
                i = i-1;
            }
            
        }
    }

    // para verificar si la jugada es valida al menos uno de los 8 elementos circundantes que rodean el elemento a mover por ello se revisan los que estan abajo (i=-1) los que estan
    // y todos sus variantes abajo izquierada,derecha y debajo(-1<=j<2) luego verifica los que estan a la misma altura(i=0) se ignora el caso de i y j iguales a 0 ya que es el mismo
    // elemento que estamos verificando finalmente se verifican los de arriba(i=1) y para que no haya errores con la primera y ultima fila y columna siempre se verifica que 
    // las tablero a verificar esten dentro de los confines de el tablero
    public static boolean jugadaEsValida(int f,int c, Graficos.Celd[][] tablero){
        for(int i=-1;i<2;i++){
            for( int j=-1;j<2;j++){
                if( i == 0 && j == 0 ){continue;}
                if(f+i >= 0 && c+j >= 0 && f+i < 9 && c+j < 9){
                    if(tablero[f+i][c+j].getValor()==0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static int calcularPuntos(int c){
            return puntos[Math.min(c,8)];
    }
    
    public static boolean verificarYEliminar(){
        boolean[][] marcar = new boolean[9][9];
        int puntosGanados = 0;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int a = tablero[i][j].getValor();
                if(a < 2 || a > 7) continue;

                for(int[] d:direcciones) {
                    int ci = i - d[0], cj = j - d[1]; // ci,cj son coordenadas antes de i,j en la misma dirección
                    if(ci >= 0 && ci < 9 && cj >= 0 && cj < 9 && tablero[ci][cj].getValor() == a ) continue;

                    int len = 1, ri = i + d[0], rj =  j + d[1]; // son las coordenadas que van después de i,j en la misma dirección
                    while(ri >= 0 && ri < 9 && rj >= 0 && rj < 9 && tablero[ri][rj].getValor() == a ) {
                        len++; ri += d[0]; rj += d[1];
                    }
                    if(len >= 5) {
                        int mi = i, mj = j;
                        for(int k = 0; k < len; k++) { 
                            marcar[mi][mj] = true;
                            mi += d[0]; mj += d[1];
                        }
                        puntosGanados += calcularPuntos(len);
                    }
                }
            }
        }

        for(int size = 9; size >= 2; size--) {  
            for(int i = 0; i <= 9 - size; i++) {
                for(int j = 0;j <= 9-size; j++) {
                    if(marcar[i][j] || tablero[i][j].getValor() != 1) continue;

                    boolean lleno=true;
                    for(int x = i; x < i + size && lleno; x++)
                        for(int y = j; y < j + size; y++)
                            if(tablero[x][y].getValor() != 1){ lleno = false; break; }

                    if(lleno) {
                        for(int x = i;x < i + size; x++)
                            for(int y = j; y < j + size; y++)
                                marcar[x][y] = true;
                        puntosGanados += calcularPuntos(size * size);
                    }
                }
            }
        }

        int eliminados = 0;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(marcar[i][j]){ tablero[i][j].setValor(0); eliminados++; }

        if(eliminados>0) {
            puntaje += puntosGanados;
            System.out.println("¡Eliminaste "+eliminados+" objetos! +"+puntosGanados+" pts");
            System.out.println("Puntaje total: "+puntaje);
            return true;
        }
        return false;
    }

    public static int[] obtenerJugada(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la fila del objeto que quiere mover");
        int f = entrada.nextInt() - 1;
        System.out.println("ingrese la columna del objeto que quiere mover");
        int c = entrada.nextInt() - 1;
        // Si quire mover un elemento vacio reinicia la funcion
        if(tablero[f][c].getValor() == 0){
            System.out.println("la posicion que desea mover esta vacia");
            siguienteJugada();
            return obtenerJugada();
        }
        return new int[]{f,c};
    }

    public static void siguienteJugada(){
        // int[][] tablero = Graficos.getTablero();
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la fila del objeto que quiere mover");
        int f = entrada.nextInt() - 1;
        System.out.println("ingrese la columna del objeto que quiere mover");
        int c = entrada.nextInt() - 1;
        // Si quire mover un elemento vacio reinicia la funcion
        if(tablero[f][c].getValor() == 0){
            System.out.println("la posicion que desea mover esta vacia");
            siguienteJugada();
            return;
        }
        //Si el elemento que quiere mover es valido continua con las siguientes comprobaciones
        if (jugadaEsValida(f, c, tablero)){
            System.out.println("ingrese la fila a donde desea moverlo");
            int fD = entrada.nextInt() - 1;
            System.out.println("ingrese la columna a donde desea moverlo");
            int cD = entrada.nextInt() - 1;
            if(tablero[fD][cD].getValor() == 0){
                tablero[fD][cD].setValor(tablero[f][c].getValor());
                tablero[f][c].setValor(0);
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
    public static void imprimirTablero(Graficos.Celd[][] tablero) {
        System.out.print("    1 2 3 4 5 6 7 8 9");
        System.out.println();
        System.out.print("    _ _ _ _ _ _ _ _ _");
        System.out.println();
        for(int i = 0; i < 9; i++) {
            System.out.print((i+1)+" | ");
            for (int j = 0; j < 9; j++) {
                System.out.print(tablero[i][j].getValor() + " ");
            }
            System.out.println();
        }
    }

    // Si hay alguna casilla no vacia significa que el juego no ha terminado 
    public static boolean terminoElJuego(){
        for(int i=0;i<9;i++){
            for (int j = 0; j < 9; j++) {
                if(tablero[i][j].getValor() == 0){
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
        Graficos grafico = new Graficos();
        iniciarTablero(obtenerSiguientesElementos());
        while (juego) { 
            int[] proxima = obtenerSiguientesElementos();
            imprimirTablero(tablero);
            System.out.println("los siguientes elementos son "+ Arrays.toString(proxima));
            siguienteJugada();
            boolean elimino = verificarYEliminar();
            if (!elimino) {
                iniciarTablero(proxima);
            }
            if (terminoElJuego()) {
                juego = false;
            }
        }
    }
}
