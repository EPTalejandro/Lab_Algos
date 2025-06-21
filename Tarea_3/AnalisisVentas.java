import java.util.ArrayList;

public class AnalisisVentas{

    ArrayList<Venta> ventas = new ArrayList<>();

    //@ public invariant ventas != null && ventas.size() > 0;

    //Crear una nueva venta
    /*@
      @ requires nombre != null;
      @ requires precio > 0;
      @ requires cantidad > 0;
      @ ensures ventas.size() == \old(ventas.size()) + 1;
      @ ensures ventas.get(ventas.size() - 1).getproducto().equals(nombre);
      @ ensures ventas.get(ventas.size() - 1).getprecio() == precio;
      @ ensures ventas.get(ventas.size() - 1).getcantidad() == cantidad;
      @*/
    public void nuevaVenta(String nombre, double precio, int cantidad){
        ventas.add(new Venta(nombre, precio, cantidad));
    }

    //Calcula el ingreso total de un producto
    //@ requires producto != null;
    //@ ensures \result = (\sum int i; 0 <= i && i < ventas.size() && ventas.get(i).getproducto().equals(producto.getproducto()); ventas.get(i).getprecio() * ventas.get(i).getcantidad());
    public double ingresoProducto(Venta producto){
        double ingreso = 0;

        //@ maintaining 0 <= ingreso + (v.getprecio() * v.getcantidad()) < Double.MAX_VALUE;
        for(Venta v : ventas){
            if(v.getproducto().equals(producto.getproducto())){
                ingreso += v.getprecio() * v.getcantidad();
            }
        }
        return ingreso;
    }

    //Calcula el ingreso total
    public void ingresoTotal(){
        double ingreso = 0;


        for(Venta v : ventas){
            ingreso += v.getprecio() * v.getcantidad();
        }
        System.out.println("- El ingreso total es de: " + ingreso + " bs");
    }

    // Calcula la cantidad total de un producto
    //@ requires producto != null;
    //@ ensures \result = (\sum int i; 0 <= i && i < ventas.size() && ventas.get(i).getproducto().equals(producto.getproducto()); ventas.get(i).getcantidad());
    public int cantidadProducto(String producto){
        int cantidad = 0;
        
        //@ maintaining 0 <= cantidad + a.getcantidad() < Integer.MAX_VALUE; 
        for(Venta a : ventas){
            if(a.getproducto().equals(producto)){
                cantidad += a.getcantidad();
            }
        }
        return cantidad;
    }

    //Determina el producto más vendido
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

    //Genera un informe por producto (cantidad total, ingreso)
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

    // Verifica si un producto fue vendido
    //@ requires producto != null;
    //@ ensures \result <==> (\exists int i; 0 <= i && i < ventas.size(); ventas.get(i).getproducto().equals(producto));
    public boolean verificarProducto(String producto){
        for(Venta v : ventas){
            if(v.getproducto().equals(producto)) return true;
        }
        return false;
    }

    //Cantidad vendida de un producto
    //@ requires producto != null;
    public void cantidadVendida(String producto){

        if(verificarProducto(producto)){
            System.out.println("- Unidades vendidas de "+ producto +" : "+ cantidadProducto(producto));
        }else System.out.println("- No se ha vendido " + producto);       
    }

    //Verificar si un producto fue vendido
    //@ requires producto != null;
    public void productoVendido(String producto){
        if(verificarProducto(producto)){
            System.out.println("- Sí se ha vendido "+ producto);
        }else System.out.println("- No se ha vendido "+ producto);
    }

    //Lista productos con ingresos mayores a un monto
    //@ requires monto >= 0;
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

        AnalisisVentas analizador = new AnalisisVentas();
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
        analizador.productoVendido("Teclado");
        analizador.ingresoProductoMayorQue(150.23);
    }
}
