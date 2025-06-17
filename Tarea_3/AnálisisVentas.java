import java.util.ArrayList;

public class AnalizadorVentas{

    public static double ingresoTotal(ArrayList<Venta> ventas){

        double ingreso = 0;

        for(Venta v : ventas){
            ingreso += v.getprecio() * v.getcantidad();
        }

        return ingreso;
    }

    public static void main(String[] args){

        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta("A", 20, 2));
        ventas.add(new Venta("B", 10, 3));

        System.out.print(ingresoTotal(ventas));

    }
}
