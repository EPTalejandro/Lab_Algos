import java.util.ArrayList;
import java.util.List;

public class AnalisisCalificacion {
    private final List<Calificacion> calificaciones = new ArrayList<>();

    public void agregar(int nota, String nombre){
        //@requires nota >= 0 && nota <= 100;
        //@requires nombre != null;
        if (nota > 100 && nota < 0) {
            throw new IllegalArgumentException("La calificacion no puede ser mayor a 100 ni menor a 0");
        }
        Calificacion calificacion = new Calificacion(nombre, nota);
        calificaciones.add(calificacion);
    }

    public double notaPromedio(){
        if (calificaciones.isEmpty()){
            throw new IllegalArgumentException("No hay calificaciones registradas");
            }

        int suma = 0;
        for (Calificacion c : calificaciones){
            suma += c.getNota();
        }
        return suma / (double) calificaciones.size();
    }

    public String obtenerMejorEstudiante(){
        if (calificaciones.isEmpty()){
            throw new IllegalArgumentException("No hay calificaciones registradas");
            }
        Calificacion mejor = calificaciones.get(0);
        for (Calificacion c : calificaciones) {
            if (c.getNota() > mejor.getNota()) {
                mejor = c;
            }
        }
        return mejor.getNombre() + " (" + mejor.getNota() + ")";
    }

    public List<String> estudiantesReprobados(){
        List<String> lista = new ArrayList<>();
            
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                lista.add(c.getNombre());
            }
        }
        return lista;
    }

    public int contarReprobados(){
        //@ensures \result == (\sum Calificacion calicacion; calificaciones; 1);
        int conteo = 0;

        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                conteo = conteo + 1;
            }
        }
        return conteo;
    }

    public List<String> superioresA(int valor){
        //@ requires valor >= 0 && valor <= 100;
        if (valor < 0 || valor > 100){
            throw new IllegalArgumentException("Valor fuera de rango");
        }
        List<String> lista = new ArrayList<>();
        for (Calificacion c : calificaciones) {
            if (c.getNota() > valor) {
            lista.add(c.getNombre());
             }
        }
        return lista;                 
    }

    public boolean hayReprobados(){
        //@ensures \result == (\forall Calificacion calificacion; calificaciones ; calificacion.getNota() < 70);
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                return true;
            }
        }
        return false;
    }
}
