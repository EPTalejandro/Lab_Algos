import java.util.Scanner;

public class Logica{
    static Graficos.Celd[][] tablero = Graficos.getTablero();
    // el 0 representa cuadros vacios
    // 1 cuadrado verde 2 bola roja 3 bola azul 4 bola amarilla 5 bola rosada 6 bola negra 7 bola morada
    static int[] elementos = new int[]{1,2,3,4,5,6,7};
    static int[][] direcciones = {{0,1},{1,0},{1,1},{1,-1}}; // horizontal, vertical, diagonal derecha y diagonal izquierda
    // Tablita de puntos
    static int[] puntos = {0,0,0,0,5,10,12,18,40}; // 4 objetos valen 5 puntos, 5 objetos 10 puntos, ... , mayor o igual que 8 son 40


    static int puntaje = 0;
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
    
    // hay una lista ya hecha de puntos donde los indices significan la cantidad de objetos eliminados se usa min por que eliminando 8 o mas
    // da el mismo puntaje, que esta en la posicion 8 de la lista y son 40 puntos 
    public static int calcularPuntos(int c){
            return puntos[Math.min(c,8)];
    }
    
    // si el elemento pasado es un 1(el cuadrado) verifica los cuadrados que rodean, si es mayor a 1(una bola) revisa las referencias de posiciones
    //@ assignable tablero[*][*];
    //@ assignable puntaje;
    public static boolean verificarYEliminar(int elemento){
        boolean[][] marcar = new boolean[9][9];
        int puntosGanados = 0;
        // Aquí evaluamos un primer caso, cuando los valores están entre 2 y 7 lo que indica que se trata de las bolas de colores
        if(elemento > 1){
            // recorremos todas las celdas del tablero 9x9
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    int a = tablero[i][j].getValor(); // nos indica el valor de la celda actual
                    // si el valor no está entre 2 y 7 no nos interesa
                    if(a < 2 || a > 7) continue;

                    // recorremos todas las direcciones posibles (horizontal, vertical y diagonal)
                    for(int[] d:direcciones) {
                        int ci = i - d[0], cj = j - d[1]; // ci,cj son coordenadas antes de i,j en la misma dirección
                        // si la celda que va antes (ci, cj) tiene el mismo valor a entonces significa que la secuencia que se iba a contar ya se realizo antes
                        // esto asegura de que no se realice más de una vez el mismo análisis y punteo 
                        if(ci >= 0 && ci < 9 && cj >= 0 && cj < 9 && tablero[ci][cj].getValor() == a ) continue;

                        int len = 1, ri = i + d[0], rj =  j + d[1];
                        // seguimos avanzando mientras haya bolas seguidas del mismo color
                        while(ri >= 0 && ri < 9 && rj >= 0 && rj < 9 && tablero[ri][rj].getValor() == a ) {
                            len++; ri += d[0]; rj += d[1];
                        }
                        // si se encuentra filas de 5 o más bolas entonces se marca para ser eliminados
                        if(len >= 5) {
                            int mi = i, mj = j;
                            for(int k = 0; k < len; k++) { 
                                marcar[mi][mj] = true;
                                mi += d[0]; mj += d[1];
                            }
                            // se calcula la puntuación segun la longitud de la fila
                            puntosGanados += calcularPuntos(len);
                        }
                    }
                }
            }
        }
        // Aquí evaluamos el segundo caso, cuando el valor es 1, es decir, nos encontramos con cuadrados verdes
        else if(elemento == 1){
            // intentamos buscar el cuadrado más grande desde 9x9 hasta 2x2
            for(int size = 9; size >= 2; size--) {  
                for(int i = 0; i <= 9 - size; i++) {
                    for(int j = 0;j <= 9-size; j++) {
                            if(marcar[i][j] || tablero[i][j].getValor() != 1) continue;
    
                        boolean lleno=true;
                        // verifica si todas las celdas del cuadrado son 1
                        for(int x = i; x < i + size && lleno; x++)
                            for(int y = j; y < j + size; y++)
                                    if(tablero[x][y].getValor() != 1){ lleno = false; break; }
    
                        if(lleno) {
                            // marca y puntua
                            for(int x = i;x < i + size; x++)
                                for(int y = j; y < j + size; y++)
                                    marcar[x][y] = true;
                            puntosGanados += calcularPuntos(size * size);
                        }
                    }
                }
            }
        }
        // elimina los elementos marcados y muestra la puntuación
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
    
    public static int getPuntaje(){
        return puntaje;
    }

    //@ requires f != null;
    //@ requires c != null;
    //@ ensures \result == True || \result ==False;
    public static boolean fueraTablero(int f, int c){
        //verifica que los valores de la posicion a mover esten fuera de los confines del tablero
        return (f<0|| c<0 || f>8 || c>8);
    }

    //obtiene la fila y columna de la siguiente jugada y la envia a la funcion que se encarga de mover y verificar 
    public static int[] obtenerJugada(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la fila del objeto que quiere mover");
        int f = entrada.nextInt() - 1;
        System.out.println("ingrese la columna del objeto que quiere mover");
        int c = entrada.nextInt() - 1;
        // Si quire mover un elemento vacio reinicia la funcion
        if(fueraTablero(f, c)){
            System.out.println("estas intentando mover un elemento por fuera del tablero");
            return obtenerJugada();
        }
        else if(!jugadaEsValida(f, c, tablero)){
            System.out.println("No puedes mover ese elemento, no tiene una casilla libre alrededor");
            return obtenerJugada();
        }
        if(tablero[f][c].getValor() == 0){
            System.out.println("la posicion que desea mover esta vacia");
            return obtenerJugada();
        }
        return new int[]{f,c};
    }

    //@ assignable tablero[*][*];
    //@ requires f != null;
    //@ requires c != null;
    public static int[] siguienteJugada(int f, int c){
        Scanner entrada = new Scanner(System.in);
        //Si el elemento que quiere mover es valido continua con las siguientes comprobaciones
        System.out.println("ingrese la fila a donde desea moverlo");
        int fD = entrada.nextInt() - 1;
        System.out.println("ingrese la columna a donde desea moverlo");
        int cD = entrada.nextInt() - 1;
        if(fueraTablero(fD, cD)){
            System.out.println("estas intentando mover un elemento hacia afuera del tablero");
            return siguienteJugada(f, c);
        }
        if(tablero[fD][cD].getValor() == 0){
            tablero[fD][cD].setValor(tablero[f][c].getValor());
            tablero[f][c].setValor(0);
            return new int[] {fD,cD};
        }
        else{
            System.out.println("la posicion a donde desea moverlo ya esta ocupado escoja otra");
            return siguienteJugada(f,c);
        }
        
    }

    // imprime el estado actual del tablero con una ligera estilizacion grafica
    // en caso de querer mostrar el tablero por terminar, puede usar esta funcion, fue usada para probar antes de tener la interfaz grafica
    // public static void imprimirTablero(Graficos.Celd[][] tablero) {
    //     System.out.print("    1 2 3 4 5 6 7 8 9");
    //     System.out.println();
    //     System.out.print("    _ _ _ _ _ _ _ _ _");
    //     System.out.println();
    //     for(int i = 0; i < 9; i++) {
    //         System.out.print((i+1)+" | ");
    //         for (int j = 0; j < 9; j++) {
    //             System.out.print(tablero[i][j].getValor() + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    // Si hay alguna casilla no vacia significa que el juego no ha terminado
    //@ ensures \result = (\forall int i; 0<=i && i<9; (\forall int j; 0<=j && j<9; tablero[i][j].getValor()==0)) 
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
        for(int i=0; i<2;i++){
            int a = (int)(Math.random() * 7);
            proxima_jugada[i] = elementos[a];
        }

        int[] conteo = new int[7];
        for(int i=0; i < 9;i++){
            for(int j=0; j<9;j++){
                int valor = tablero[i][j].getValor();
                if(valor>=1 && valor<= 7){
                    // valor vendria figurando entre 1 y 7 esto justifica la siguiente asignacion ya que que los valores de cada numero
                    // se guardarian en la posicion equivalente a su indice en la lista menos 1 es decir las apariciones de 4 estarian en 
                    // la posicion 3, asi se recorre todo el tablero una sola ves y cada posicion guarda el total de ese numero 
                    conteo[valor-1] = conteo[valor-1] + 1;
                }
            }
        }
        int menos_apariciones = 0;
        for(int i=1; i < 7;i++){
            //se compara el primero con el siguiente y asi sucesivamente 
            if(conteo[i] < conteo[menos_apariciones])
            menos_apariciones=i;
        }
        proxima_jugada[2] = elementos[menos_apariciones];
        return proxima_jugada;
    }
}
