import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalisisCalificacion {
    private final List<Calificacion> calificaciones = new ArrayList<>();

    public void agregar(Calificacion c){
        if (c == null) {
            throw new IllegalArgumentException("La calificacion no puede ser nula");
        }
        calificaciones.add(c);
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
        int conteo = 0;

        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                conteo++;
            }
        }
        return conteo;
    }

    public List<String> superioresA(int valor){
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
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                return true;
            }
        }
        return false;
    }
}
