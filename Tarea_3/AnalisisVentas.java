import java.util.ArrayList;

public class AnalisisVentas{

    //@ spec_public
    ArrayList<Venta> ventas = new ArrayList<>();

    //@ public invariant ventas != null;

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
    /*@ requires producto != null;
      @ ensures \result == (\sum int i; 0 <= i && i < ventas.size();
                             ventas.get(i).getproducto().equals(producto) ? ventas.get(i).getprecio() * ventas.get(i).getcantidad() : 0);
      @*/
    public double ingresoProducto(String producto){
        double ingreso = 0;

        //@ maintaining 0 <= ingreso + (v.getprecio() * v.getcantidad()) < Double.MAX_VALUE;
        for(Venta v : ventas){
            if(v.getproducto().equals(producto)){
                ingreso += v.getprecio() * v.getcantidad();
            }
        }
        return ingreso;
    }

    //Calcula el ingreso total
    //@ requires true;
    //@ ensures \result == (\sum int i; 0 <= i && i < ventas.size(); ventas.get(i).getprecio() * ventas.get(i).getcantidad);
    public double ingresoTotal(){
        double ingreso = 0;

        //@ maintaining 0 <= ingreso + (v.getprecio() * v.getcantidad()) < Double.MAX_VALUE;
        for(Venta v : ventas){
            ingreso += v.getprecio() * v.getcantidad();
        }
        return ingreso;
    }

    // Calcula la cantidad total de un producto
    //@ requires producto != null;
    //@ ensures \result == (\sum int i; 0 <= i && i < ventas.size(); ventas.get(i).getproducto().equals(producto) ? ventas.get(i).getcantidad() : 0);
    //@ pure
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
    /*@ requires true;
      @ ensures (\forall int i; 0 <= i && i < ventas.size();
      @          cantidadProducto(\result) >= cantidadProducto(ventas.get(i).getproducto()));
      @*/
    public String productoMasVendido(){
        String masVendido = "";
        int cantidadMasVendido = 0;

        for(Venta producto : ventas){
            int vendido = cantidadProducto(producto.getproducto());
            if(cantidadMasVendido < vendido){
                masVendido = producto.getproducto();
                cantidadMasVendido = vendido;
            }
        }
        return masVendido;
    }

    //Genera un informe por producto (cantidad total, ingreso)
    //@ requires true;
    //@ ensures true;
    public ArrayList<ArrayList<String>> informeProductos(){
        ArrayList<ArrayList<String>> informe = new ArrayList<>();

        for(Venta producto : ventas){

            if(!informe.contains(producto.getproducto())){
                ArrayList<String> infProducto = new ArrayList<>();

                int vendido = cantidadProducto(producto.getproducto());
                double ingreso = ingresoProducto(producto.getproducto());

                infProducto.add(producto.getproducto());
                infProducto.add(String.valueOf(vendido));
                infProducto.add(String.valueOf(ingreso));
                informe.add(infProducto);
            }
        }
        return informe;
    }

    // Verifica si un producto fue vendido
    //@ requires producto != null;
    //@ ensures \result <==> (\exists int i; 0 <= i && i < ventas.size(); ventas.get(i).getproducto().equals(producto));
    //@ pure
    public boolean productoVendido(String producto){
        for(Venta v : ventas){
            if(v.getproducto().equals(producto)) return true;
        }
        return false;
    }

    //Cantidad vendida de un producto
    //@ requires producto != null;
    //@ ensures \result == (productoVendido(producto) ? (\sum int i; 0 <= i && i < ventas.size(); ventas.get(i).getproducto().equals(producto) ? ventas.get(i).getcantidad() : 0) : 0);
    public int cantidadVendida(String producto){
        if(productoVendido(producto)){
            return cantidadProducto(producto);
        }else return 0;       
    }

    //Lista productos con ingresos mayores a un monto
    //@ requires monto >= 0;
    public ArrayList<String> ingresoProductoMayorQue(double monto){
        ArrayList<String> mayor = new ArrayList<>();
        for(Venta producto : ventas){
            if(!mayor.contains(producto.getproducto()) && monto < ingresoProducto(producto.getproducto())){
                mayor.add(new String(producto.getproducto()));
            }
        }
        return mayor;
    }
}
