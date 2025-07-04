
import java.util.HashSet;


public class Inventario{
    
    // Crea un nuevo producto 
    public static void añadirProducto(String nombre,int cantidad,double precio){
        Productos producto = new Productos(nombre,cantidad,precio);
        Productos.getLista().add(producto);
    }

    // actualiza la cantidad registrada de dicho producto, el numero actualziacion puede ser negativo o positivo dependiendo si es venta o reposicion
    public static void actulizarCantidad(int actualizacion,Productos producto){
        //@ensures producto.cantidad + actualizacion >= 0 ;
        if(producto.getCantidad() + actualizacion >= 0){
            producto.setCantidad(producto.getCantidad() - actualizacion);
        }
        else{
            System.err.println("no hay sufientes "+producto.getNombre()+" en stock para restar: " + actualizacion);
        }
    }

    // Lista todos los productos registrados
    public static void listarProductos(){
        HashSet<String> lista = new HashSet<>();
        for(Productos producto: Productos.getLista()){
            lista.add(producto.getNombre());
        }
        System.out.println("Los productos en inventario son: " + lista);
    }

    // Da la suma de el valor total de el inventario entero
    public static void valorInventario(){
        //@ ensures valor == (\sum Productos producto;Productos.listaProductos;producto.precio * producto.cantidad)
        double valor = 0;
        for(Productos producto: Productos.getLista()){
            valor = valor + (producto.getPrecio() * producto.getCantidad());
        }
        System.out.println("El valor total de el inventario es: " + valor + "Bolívares");
    }

    // lista todos los productos agotados(aquellos con cantidad = 0)
    public static void productosAgotados(){
        HashSet<String> agotados = new HashSet<>();
        for(Productos producto: Productos.getLista()){
            if(producto.getCantidad() == 0){
                agotados.add(producto.getNombre());
            }
        }
        System.out.println("Los productos agotados son: " + agotados);
    }

    // da el producto con mayor valor actualmente en el inventario tomando en cuenta precio y disponibilidad
    public static void mayorValorTotal(){
        double valor_max = 0;
        String mas_caro = new String();
        for(Productos producto: Productos.getLista()){
            if( (producto.getPrecio() * producto.getCantidad()) > valor_max){
                valor_max = producto.getPrecio() * producto.getCantidad();
                mas_caro = producto.getNombre();
            }    
        }
        System.out.println("El producto con mayor valor total es: "+ mas_caro + " costando :" + valor_max + "Bolívares");

    }

    // Da el producto con el valor unitario mas alto 
    public static void productoMasCaro(){
        String mas_caro = new String();
        double valor_max = 0;
        for(Productos producto: Productos.getLista()){
            if(producto.getPrecio() > valor_max){
                valor_max = producto.getPrecio();
                mas_caro = producto.getNombre();
            }
        }
        System.out.println("El producto mas caro del inventario es: "+ mas_caro + " costando :" + valor_max + "Bolívares");
    }
}