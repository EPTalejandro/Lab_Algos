import java.util.Arrays;
public class Main{
     public static void main(String[] args) {
        boolean juego = true;
        Graficos grafico = new Graficos();
        Logica.iniciarTablero(Logica.obtenerSiguientesElementos());
        int[] proxima = Logica.obtenerSiguientesElementos();

        while (juego) {
            grafico.actulizarPanelSiguientes(proxima); 
            // imprimirTablero(tablero);
            System.out.println("los siguientes elementos son "+ Arrays.toString(proxima));
            int[] movimiento = Logica.obtenerJugada();
            int[] movido = Logica.siguienteJugada(movimiento[0],movimiento[1]);
            boolean elimino = Logica.verificarYEliminar(Logica.tablero[movido[0]][movido[1]].getValor());
            // Actualiza la interfaz gráfica después de cada jugada
            grafico.repintarTablero();
            grafico.actualizarPuntaje(Logica.getPuntaje());
            if (!elimino) {
                Logica.iniciarTablero(proxima);
                proxima = Logica.obtenerSiguientesElementos();
                // Actualiza la interfaz gráfica después de agregar nuevos elementos
                grafico.repintarTablero();
                grafico.actualizarPuntaje(Logica.getPuntaje());
                if(Logica.terminoElJuego()){
                    System.out.println("EL juego termino, se lleno el tablero. Puntuacion final: "+Logica.getPuntaje());
                    grafico.dispose();
                    break;
                }
            }
        }
    }
}