
import java.util.HashSet;


public class Productos{
    String nombre;
    int cantidad;
    double precio;
    static HashSet<Productos> listaProductos = new HashSet<>();
    public Productos(String nombre,int cantidad, double precio){

        //@requires nombre.length > 2 && precio >= 0 && cantidad >= 0;
        if(nombre.length()<2 || precio < 0 || cantidad < 0){
            throw new IllegalArgumentException("Los argumentos pasados para registrar un producto son invalidos");
        }
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        listaProductos.add(this);
    }
}