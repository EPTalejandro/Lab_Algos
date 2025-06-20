
import java.util.HashSet;


public class Productos{
    private String nombre;
    private int cantidad;
    private double precio;
    private static final HashSet<Productos> listaProductos = new HashSet<>();
    
    public Productos(String nombre,int cantidad, double precio){

        //@requires nombre.length > 2 && precio >= 0 && cantidad >= 0;
        if(nombre.length()<2 || precio < 0 || cantidad < 0){
            throw new IllegalArgumentException("Los argumentos pasados para registrar un producto son invalidos");
        }
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static HashSet<Productos> getLista(){
        return Productos.listaProductos;
    }

    public double getPrecio(){
        return this.precio;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int actualizacion){
        this.cantidad = actualizacion;
    }

    public String getNombre(){
        return this.nombre;
    }
}