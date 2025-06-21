public class Venta{

    private final String producto;
    private final double precio;
    private final int cantidad;

    // constructor
    //@ requires producto != null;
    //@ requires precio > 0;
    //@ requires cantidad > 0;
    public Venta(String producto, double precio, int cantidad){
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

    /*@ pure @*/ public String getproducto(){
        return producto;
    }

    /*@ pure @*/ public double getprecio(){
        return precio;
    }

    /*@ pure @*/ public int getcantidad(){
        return cantidad;
    }

    
}
