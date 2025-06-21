public class Venta{

    private final String producto;
    private final double precio;
    private final int cantidad;

    // constructor
    public Venta(String producto, double precio, int cantidad){
        //@ requires producto != null;
        //@ requires precio > 0;
        //@ requires cantidad > 0;
        if( producto == null){
            throw new IllegalArgumentException("El producto a registrar no puede ser nulo");
        }
        else if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser menor a cero");
        }
        else if(cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser menor a cero");
        }
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
