public class Calificacion{

    private final String nombre;
    private final int nota;

    //@ requires nombre != null;
    //@ requires nota >= 0 && nota <= 100;
    //@ ensures this.nombre.equals(nombre);
    //@ ensures this.nota == nota;
    public Calificacion(String nombre, int nota){
        //@requires nota >= 0 && nota <= 100;
        //requires nombre != null;
        if (nombre == null){
            throw new IllegalArgumentException("Debe indicar un nombre válido");
            }
        if (nota < 0 || nota > 100){
            throw new IllegalArgumentException("Nota por fuera del rango");
        }
        this.nombre = nombre; 
        this.nota = nota;
    }

    

        //@ ensures \result != null;
    public String getNombre(){
            return nombre;
        }
        //@ ensures \result nota >= 0 && nota <= 100;
        public int getNota(){
            return nota;
        }

    @Override
    public String toString(){
        return nombre + "("+ nota +")";
    }
}
