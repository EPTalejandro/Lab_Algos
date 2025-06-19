
import java.util.HashSet;


public class Productos{
    String nombre;
    int cantidad;
    double precio;
    static HashSet<Productos> productos;
    public Productos(String nombre,int cantidad, double precio){

        //@requires nombre.length > 0 && precio >= 0 && cantidad >= 0;

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        productos.add(this);
    }
}