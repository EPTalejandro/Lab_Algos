import java.util.ArrayList;

public class MainVentas{

    //Función main para crear ventas y probar las funciones
    public static void main(String[] args){

        AnalisisVentas analizador = new AnalisisVentas();

        analizador.nuevaVenta("Pendrive", 60, 2);
        analizador.nuevaVenta("Cargador", 45, 1);
        analizador.nuevaVenta("Baterías", 30, 3);
        analizador.nuevaVenta("Pendrive", 60, 5);
        analizador.nuevaVenta("Computadora", 300, 1);
        analizador.nuevaVenta("Cargador", 45, 3);
        analizador.nuevaVenta("Cables USB", 20, 6);

        System.out.println("- El ingreso total es de: " + analizador.ingresoTotal() + " bs");
        System.out.println("- Producto más vendido: " + analizador.productoMasVendido());

        ArrayList<ArrayList<String>> informe = analizador.informeProductos();
        System.out.printf("| %-15s | %-10s | %-12s |\n", "Producto", "Cantidad", "Ingresos");
        System.out.println("-----------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-12s |\n", informe.get(0).get(0), informe.get(0).get(1), informe.get(0).get(2));

        
        System.out.println("- Unidades vendidas de Cargador: "+ analizador.cantidadVendida("Cargador"));
        System.out.println("- ¿Se ha vendido Teclado? "+ analizador.productoVendido("Teclado"));

        analizador.ingresoProductoMayorQue(150.23);
    }
}
