public class Calificacion{

    private final String nombre;
    private final int nota;

    public Calificacion(String nombre, int nota){
        if (nombre == null){
            throw new IllegalArgumentException("Debe indicar un nombre válido");
            }
        if (nota < 0 || nota > 100){
            throw new IllegalArgumentException("Nota por fuera del rango");
        }
        this.nombre = nombre; 
        this.nota = nota;
    }
        public String getNombre(){
            return nombre;
        }
        public int getNota(){
            return nota;
        }
    @Override
    public String toString(){
        return nombre + "("+ nota +")";
    }
}
