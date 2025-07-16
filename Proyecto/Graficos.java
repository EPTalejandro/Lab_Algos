import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graficos extends JFrame {
    private static final int FIL = 9;
    private static final int COL = 9;
    static final Celd[][] tablero = new Celd[FIL][COL];
    private JLabel puntaje;
    // La lista de colores sera usada para asignarle un color a cada figura a la hora de ser dibujada, dependiendo de su numero(valor)
    private static final Color[] colores = {Color.GREEN,Color.RED,Color.BLUE,Color.YELLOW,Color.PINK,Color.ORANGE,Color.MAGENTA};

    // crear lista con los colores dependiendo de la posicion 

    // Coordenadas de la celda seleccionada
    private int selecFila = -1;
    private int selecCol = -1;

    public static Celd[][] getTablero(){
        return tablero;
    }

    // El constructor del `TableroJuego` configura la ventana: título, cierre, tamaño, 
    // posición, y divide la interfaz en dos secciones: la del puntaje y la del tablero.
    public Graficos() {
        super("Tablero 9x9 con Fichas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior para mostrar el puntaje
        JPanel topPanel = new JPanel();
        puntaje = new JLabel("Puntaje: "); // Espacio para puntaje
        topPanel.add(puntaje);
        add(topPanel, BorderLayout.NORTH);

        // Panel del tablero (9x9)
        JPanel tableroPanel = new JPanel(new GridLayout(FIL, COL));
        for (int r = 0; r < FIL; r++) {
            for (int c = 0; c < COL; c++) {
                Celd cell = new Celd(r, c);
                tablero[r][c] = cell;
                tableroPanel.add(cell);
            }
        }
        add(tableroPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Clase interna que extiende `JPanel` y representa cada casilla del tablero.
    // Maneja el dibujo de la ficha y la detección de clics del ratón.
    public class Celd extends JPanel implements MouseListener {
        private int fila, col, valor;

        public Celd(int fila, int col) {
            this.fila = fila;
            this.col = col;
            this.valor = 0; // 0 representa que está vacía la celda
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            addMouseListener(this);
        }

        public int getValor(){
           return this.valor;
        }

        public void setValor(int valorN){
            this.valor = valorN;
        }

        // Sobrescribe `paintComponent` para dibujar en la casilla: si `hasPiece` es `true`,
        // dibuja un óvalo (ficha); si la celda está seleccionada (`selecFila/Col`),
        // dibuja un borde rojo alrededor.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (valor > 1) {
                g.setColor(colores[valor - 1]);
                int diam = Math.min(getWidth(), getHeight()) - 10;
              	// Dibuja un círculo centrado
                g.fillOval((getWidth() - diam) / 2, (getHeight() - diam) / 2, diam, diam);
            } else if (valor == 1){
              	g.setColor(colores[valor - 1]);
                int size = Math.min(getWidth(), getHeight()) - 10;
        		// Dibuja un cuadrado centrado
        		g.fillRect((getWidth() - size) / 2, (getHeight() - size) / 2, size, size);
              	
            }
            // Resaltar selección
            if (fila == selecFila && col == selecCol) {
                g.setColor(Color.RED);
                g.drawRect(2, 2, getWidth()-4, getHeight()-4);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Caso 1: Seleccionar ficha si no hay selección previa y hay ficha en esta celda
            if (selecFila == -1 && valor != 0) {
                selecFila = fila;
                selecCol = col;
                repaintAll();
            }
            // Caso 2: Intentar mover ficha seleccionada a celda vacía
            else if (selecFila != -1 && valor == 0) {
                valor = tablero[selecFila][selecCol].valor;
                tablero[selecFila][selecCol].valor = 0;
                selecFila = -1;
                selecCol = -1;
                repaintAll();
            }
            // Caso 3: Deseleccionar ficha si se pulsa de nuevo sobre ella
            else if (selecFila == fila && selecCol == col) {
                selecFila = -1;
                selecCol = -1;
                repaintAll();
            }
        }

        // Método auxiliar que fuerza el repintado de todas las casillas del tablero,
        // necesario después de mover o deseleccionar fichas para actualizar el aspecto de cada `Celd`.
        private void repaintAll() {
            for (int r = 0; r < FIL; r++) {
                for (int c = 0; c < COL; c++) {
                    tablero[r][c].repaint();
                }
            }
        }

        // Métodos vacíos requeridos por MouseListener
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    }

    // Punto de entrada de la aplicación. Crea una instancia del `TableroJuego`,
    // coloca algunas fichas de ejemplo en la esquina superior izquierda
    // y solicita repintar para mostrar las fichas iniciales.
    public static void main(String[] args) {

    }
}
