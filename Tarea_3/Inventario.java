
import java.util.HashSet;


public class Inventario{
    
    public static void añadirProducto(String nombre,int cantidad,double precio){
        new Productos(nombre,cantidad,precio);
    }

    public static void actulizarCantidad(int actualizacion,Productos producto){
        if(producto.cantidad + actualizacion >= 0){
            producto.cantidad = producto.cantidad - actualizacion;
        }
        else{
            System.err.println("no hay sufientes "+producto.nombre+" en stock para restar: " + actualizacion);
        }
    }

    public static void listarProductos(){
        HashSet<String> lista = new HashSet<>();
        for(Productos producto: Productos.productos){
            lista.add(producto.nombre);
        }
        System.out.println("Los productos en inventario son: " + lista);
    }

    public static void valorInventario(){
        double valor = 0;
        for(Productos producto: Productos.productos){
            valor = valor + (producto.precio * producto.cantidad);
        }
        System.out.println("El valor total de el inventario es: " + valor + "Bolívares");
    }

    public static void productosAgotados(){
        HashSet<String> agotados = new HashSet<>();
        for(Productos producto: Productos.productos){
            if(producto.cantidad == 0){
                agotados.add(producto.nombre);
            }
        }
        System.out.println("Los productos agotados son: " + agotados);
    }

    public static void mayorValorTotal(){
        double valor_max = 0;
        String mas_caro = new String();
        for(Productos producto: Productos.productos){
            if((producto.precio*producto.cantidad) > valor_max){
                valor_max = producto.precio*producto.cantidad;
                mas_caro = producto.nombre;
            }    
        }
        System.out.println("El producto con mayor valor total es: "+ mas_caro + " costando :" + valor_max + "Bolívares");

    }

    public static void productoMasCaro(){
        String mas_caro = new String();
        double valor_max = 0;
        for(Productos producto: Productos.productos){
            if(producto.precio > valor_max){
                valor_max = producto.precio;
                mas_caro = producto.nombre;
            }
        }
        System.out.println("El producto mas caro del inventario es: "+ mas_caro + " costando :" + valor_max + "Bolívares");
    }
}