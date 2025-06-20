import java.util.ArrayList;
import java.util.List;

public class AnalisisVentas{

    ArrayList<Venta> ventas = new ArrayList<>();

    //Crear una nueva venta
    public void nuevaVenta(String nombre, double precio, int cantidad){
        ventas.add(new Venta(nombre, precio, cantidad));
    }

    public double ingresoProducto(Venta producto){
        double ingreso = 0;


        for(Venta v : ventas){
            if(producto.getproducto() == v.getproducto()){
                ingreso += v.getprecio() * v.getcantidad();
            }
        }
        return ingreso;
    }

    //Calcular el ingreso total
    public void ingresoTotal(){
        double ingreso = 0;


        for(Venta v : ventas){
            ingreso += v.getprecio() * v.getcantidad();
        }
        System.out.println("- El ingreso total es de: " + ingreso + " bs");
    }

    public int cantidadProducto(String producto){
        int cantidad = 0;
        
        for(Venta a : ventas){
            if(a.getproducto().equals(producto)){
                cantidad += a.getcantidad();
            }
        }
        return cantidad;
    }

    //Determinar el producto m´as vendido
    public void productoMasVendido(){
        String masVendido = "";
        int cantidadMasVendido = 0;


        for(Venta producto : ventas){
            int vendido = cantidadProducto(producto.getproducto());
            if(cantidadMasVendido < vendido){
                masVendido = producto.getproducto();
                cantidadMasVendido = vendido;
            }
        }
        System.out.println("- Producto más vendido): " + masVendido);
        System.out.println("  Cantidad vendida: "+ cantidadMasVendido);
    }

    //Generar un informe por producto (cantidad total, ingreso)
    public void informeProductos(){
        ArrayList<String> informe = new ArrayList<>();

        System.out.println("-----------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-12s |\n", "Producto", "Cantidad", "Ingresos");

        for(Venta producto : ventas){

            if(!informe.contains(producto.getproducto())){

                int vendido = cantidadProducto(producto.getproducto());
                double ingreso = ingresoProducto(producto);

                System.out.println("-----------------------------------------------");
                System.out.printf("| %-15s | %-10d | %-9.2f bs |\n", producto.getproducto(), vendido, ingreso);

                informe.add(new String(producto.getproducto()));
            }
        }
        System.out.println("-----------------------------------------------");
    }

    public boolean verificarProducto(String producto){
        for(Venta v : ventas){
            if(v.getproducto().equals(producto)) return true;
        }
        return false;
    }

    //Obtener la cantidad total vendida de un producto
    public void cantidadVendida(String producto){

        if(verificarProducto(producto)){
            System.out.println("- Unidades vendidas de "+ producto +" : "+ cantidadProducto(producto));
        }else System.out.println("- No se ha vendido " + producto);       
    }

    //Verificar si un producto fue vendido
    public void productoVendido(String producto){
        if(verificarProducto(producto)){
            System.out.println("- Sí se ha vendido "+ producto);
        }else System.out.println("- No se ha vendido "+ producto);
    }

    //Listar productos cuyo ingreso supere un monto dado.

    public void ingresoProductoMayorQue(double monto){
        ArrayList<String> mayor = new ArrayList<>();
        int i = 0;

        System.out.println("- Producto(s) con ingresos mayores a "+ monto);

        for(Venta producto : ventas){

            if(!mayor.contains(producto.getproducto()) && monto < ingresoProducto(producto)){
                int vendido = cantidadProducto(producto.getproducto());
                mayor.add(new String(producto.getproducto()));
                int n = i + 1;

                System.out.println(n +". "+ producto.getproducto());
                i++;
            }
        }
    }

    //Función main para crear ventas y probar las funciones
    public static void main(String[] args){

        AnalizadorVentas analizador = new AnalizadorVentas();
        analizador.nuevaVenta("Pendrive", 60, 2);
        analizador.nuevaVenta("Cargador", 45, 1);
        analizador.nuevaVenta("Baterías", 30, 3);
        analizador.nuevaVenta("Pendrive", 60, 5);
        analizador.nuevaVenta("Computadora", 300, 1);
        analizador.nuevaVenta("Cargador", 45, 3);
        analizador.nuevaVenta("Cables USB", 20, 6);
        analizador.ingresoTotal();
        analizador.productoMasVendido();
        analizador.informeProductos();
        analizador.cantidadVendida("Cargador");
        analizador.productoVendido("Pendrive");
        analizador.ingresoProductoMayorQue(150.23);

    }
}
