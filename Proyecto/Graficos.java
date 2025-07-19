import java.awt.*;
import javax.swing.*;

public class Graficos extends JFrame {
    private static final int FIL = 9;
    private static final int COL = 9;
    static final Celd[][] tablero = new Celd[FIL][COL];
    private final JLabel puntos;
    private final static Celd[] siguientesElementos = new Celd[3];
    // La lista de colores sera usada para asignarle un color a cada figura a la hora de ser dibujada, dependiendo de su numero(valor)
    private static final Color[] colores = {Color.GREEN,Color.RED,Color.BLUE,Color.YELLOW,Color.PINK,Color.BLACK,Color.MAGENTA}; 

    public static Celd[][] getTablero(){
        return tablero;
    }

    // El constructor del `TableroJuego` configura la ventana: título, cierre, tamaño, 
    // posición, y divide la interfaz en dos secciones: una el panel superior con el puntaje, 
    // los siguientes elementos y la numeración de las filas, y la segunda con la numeración de las filas y el tablero.
    public Graficos() {
        super("Lineas de colores y rectángulos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creación del JPanel para la sección superior y se establece su tamaño.
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(700, 100));

        // Creación del JLabel para el puntaje, se asigna una fuente, tamaño y coloca en negrita las letras.
        // Se añade el JLabel al topPanel.
        puntos = new JLabel("Puntaje: " + Logica.puntaje, SwingConstants.CENTER);
        puntos.setFont(new Font("SansSerif", Font.BOLD, 16));
        topPanel.add(puntos);

        // Creación de JPanel para contener los siguientes elementos
        // Se centran los elementos a lo ancho y alto del panel, además de estableces un tamaño para el mismo.
        JPanel contenedorSiguientes = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        contenedorSiguientes.setPreferredSize(new Dimension(300,60));

        JLabel tituloSiguientes = new JLabel("Siguientes:");
        tituloSiguientes.setFont(new Font("SansSerif", Font.BOLD, 14));
        contenedorSiguientes.add(tituloSiguientes, BorderLayout.NORTH);

        // Recore la lista siguientesElementos para darles distintas propiedades e introducirlos
        // en el contenedorSiguientes.
        // Por último se agrega contenedorSiguientes al topPanel.
        //@ maintaining 0 <= i <= 3;
        for(int i = 0; i < 3; i++){
            siguientesElementos[i] = new Celd();
            siguientesElementos[i].setBorder(null);
            siguientesElementos[i].setBackground(topPanel.getBackground());
            siguientesElementos[i].setMinimumSize(new Dimension(50,50));
            siguientesElementos[i].setPreferredSize(new Dimension(50,50));
            contenedorSiguientes.add(siguientesElementos[i]);
        }
        topPanel.add(contenedorSiguientes,BorderLayout.EAST);

        // Panel adicional para contener un espacio en blanco y las etiquetas de las columnas.
        JPanel colfix = new JPanel(new BorderLayout());

        // Espacio en blanco para la corrección de la posición de las etiquetas de las columnas.
        JPanel blankSpace = new JPanel();
        blankSpace.setPreferredSize(new Dimension(40, 30));
        colfix.add(blankSpace, BorderLayout.WEST);

        // Panel superior para la numeración de las columnas, se usa GridLayout para crear 
        // una cuadrícula de 1 fila y, para este caso en específico, 9 columnas, aunque si el valor
        // COL se modifica la cantidad de columnas también variará.
        // Se establece un tamaño para el panel.
        JPanel colLabels = new JPanel(new GridLayout(1, COL));
        colLabels.setPreferredSize(new Dimension(660, 30));
        //@ maintaining 0 <= c <= COL;
        for (int c = 0; c < COL; c++) {
            JLabel label = new JLabel(String.valueOf(c + 1), SwingConstants.CENTER);
            colLabels.add(label);
        }

        colfix.add(colLabels, BorderLayout.CENTER);
        topPanel.add(colfix, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // Panel izquierdo para etiquetas de fila
        JPanel filaLabels = new JPanel(new GridLayout(FIL, 1));
        filaLabels.setPreferredSize(new Dimension(40, 700));
        //@ maintaining 0 <= r <= FIL;
        for (int r = 0; r < FIL; r++) {
            JLabel label = new JLabel(String.valueOf(r + 1), SwingConstants.CENTER);
            filaLabels.add(label);
        }
        add(filaLabels, BorderLayout.WEST);

        // Creación Panel del tablero (9x9)
        JPanel tableroPanel = new JPanel(new GridLayout(FIL, COL));
        //@ maintaining 0 <= r <= FIL;
        for (int r = 0; r < FIL; r++) {
            //@ maintaining 0 <= c <= COL;
            for (int c = 0; c < COL; c++) {
                Celd cell = new Celd();
                tablero[r][c] = cell;
                tableroPanel.add(cell);
            }
        }
        add(tableroPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Recibe una lista con los nuevos elementos que se agregarán al tablero, actualiza
    // la lista siguientesElementos y repinta cada uno para actualizar la interfaz gráfica.
    //@ requires siguientes != null && siguientes.length == 3;
    //@ assignable siguientesElementos[*];
    public void actulizarPanelSiguientes(int[] siguientes){
        //@ maintaining 0 <= i <= 3;
        for(int i = 0; i < 3; i++){
            siguientesElementos[i].valor = siguientes[i];
            siguientesElementos[i].repaint();
        }
    }

    // Método para actualizar el puntaje en la etiqueta
    //@ requires nuevoPuntaje != null;
    public void actualizarPuntaje(int nuevoPuntaje) {
        puntos.setText("Puntaje: " + nuevoPuntaje);
    }

    // Método para repintar todas las celdas del tablero
    //@ requires true;
    public void repintarTablero() {
        //@ maintaining 0 <= r <= FIL;
        for (int r = 0; r < FIL; r++) {
            //@ maintaining 0 <= c <= COL;
            for (int c = 0; c < COL; c++) {
                tablero[r][c].repaint();
            }
        }
    }

    // Clase interna que extiende `JPanel` y representa cada casilla del tablero.
    // Maneja el dibujo de la ficha.
    public class Celd extends JPanel {
        private int valor;

        // Constructor de la clase Celd, inicialmente asigna a valor el 0.
        public Celd() {
            this.valor = 0; // 0 representa que está vacía la celda
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        //@ requires true;
        //@ ensures 0 <= result <= 7;
        public int getValor(){
           return this.valor;
        }

        //@ requires 0 <= valorN <= 7;
        public void setValor(int valorN){
            this.valor = valorN;
        }

        // Sobrescribe `paintComponent` para dibujar en la casilla si `valor` es distinto de 0,
        // dibuja un círculo (ficha) si valor > 1, 
        // dibuja un rectángulo si valor == 1,
        // si la celda está seleccionada `selecFila/Col` dibuja un borde rojo alrededor.
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
        }
    }
}
