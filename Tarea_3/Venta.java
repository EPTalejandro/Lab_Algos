public class Venta{

    private String producto;
    private double precio;
    private int cantidad;

    public Venta(String producto, double precio, int cantidad){
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos getter para obtener los atributos

    public String getproducto(){
        return producto;
    }

    public double getprecio(){
        return precio;
    }

    public int getcantidad(){
        return cantidad;
    }

    
}
