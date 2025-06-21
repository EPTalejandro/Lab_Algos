import java.util.ArrayList;
import java.util.List;

public class AnalisisCalificacion {
    private final List<Calificacion> calificaciones = new ArrayList<>();
    
    //@ requires nota >= 0 && nota <= 100;
    //@ requires nombre != null;
    //@ ensures calificaciones.size() == \old(calificaciones.size()) + 1;    
    public void agregar(int nota, String nombre){
        if (nombre == null) {  // Añadido: verificación requerida por JML
            throw new IllegalArgumentException("Nombre no puede ser null");
        }
        if (nota > 100 || nota < 0) {
            throw new IllegalArgumentException("La calificacion no puede ser mayor a 100 ni menor a 0");
        }
        Calificacion calificacion = new Calificacion(nombre, nota);
        calificaciones.add(calificacion);
    }
    
    //@ requires calificaciones.size() > 0;
    //@ ensures \result >= 0 && \result <= 100;
    public double notaPromedio(){
        if (calificaciones.isEmpty()){
            throw new IllegalArgumentException("No hay calificaciones registradas");
            }

        int suma = 0;
        //@ maintaining suma == (\sum int i; 0 <= i && i < \index; calificaciones.get(i).getNota());
        for (Calificacion c : calificaciones){
            suma += c.getNota();
        }
        return suma / (double) calificaciones.size();
    }
    
    //@ requires calificaciones.size() > 0;
    //@ ensures (\exists Calificacion mejor; calificaciones.contains(mejor);
    //@         \result.equals(mejor.getNombre() + " (" + mejor.getNota() + ")") &&
    //@         (\forall Calificacion c; calificaciones.contains(c); c.getNota() <= mejor.getNota()));
    public String obtenerMejorEstudiante(){
        if (calificaciones.isEmpty()){
            throw new IllegalArgumentException("No hay calificaciones registradas");
            }
        Calificacion mejor = calificaciones.get(0);
        //@ maintaining (\forall int i; 0 <= i < \index; calificaciones.get(i).getNota() <= mejor.getNota());
        for (Calificacion c : calificaciones) {
            if (c.getNota() > mejor.getNota()) {
                mejor = c;
            }
        }
        return mejor.getNombre() + " (" + mejor.getNota() + ")";
    }
    
    //@ ensures \result != null;
    //@ ensures (\forall String s; \result.contains(s); 
    //@         (\exists Calificacion c; calificaciones.contains(c); c.getNombre().equals(s) && c.getNota() < 70));
    public List<String> estudiantesReprobados(){
        List<String> lista = new ArrayList<>();
        //@ maintaining (\forall String s; lista.contains(s);
        //@              (\exists Calificacion c; calificaciones.subList(0, \index).contains(c);
        //@               c.getNombre().equals(s) && c.getNota() < 70));
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                lista.add(c.getNombre());
            }
        }
        return lista;
    }
    
    //@ ensures \result >= 0;
    //@ ensures \result == (\num_of Calificacion c; calificaciones.contains(c); c.getNota() < 70);
    public int contarReprobados(){
        int conteo = 0;
        //@ maintaining conteo == (\num_of int i; 0 <= i < \index; calificaciones.get(i).getNota() < 70);
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                conteo = conteo + 1;
            }
        }
        return conteo;
    }

    //@ requires valor >= 0 && valor <= 100;
    //@ ensures \result != null;
    //@ ensures (\forall String s; \result.contains(s);
    //@         (\exists Calificacion c; calificaciones.contains(c); c.getNombre().equals(s) && c.getNota() > valor));
    public List<String> superioresA(int valor){
        if (valor < 0 || valor > 100){
            throw new IllegalArgumentException("Valor fuera de rango");
        }
        List<String> lista = new ArrayList<>();

        //@ maintaining (\forall String s; lista.contains(s);
        //@              (\exists Calificacion c; calificaciones.subList(0, \index).contains(c);
        //@               c.getNombre().equals(s) && c.getNota() > valor));
        for (Calificacion c : calificaciones) {
            if (c.getNota() > valor) {
            lista.add(c.getNombre());
             }
        }
        return lista;                 
    }
    //@ ensures \result == (\exists Calificacion c; calificaciones.contains(c); c.getNota() < 70);
    public boolean hayReprobados(){
        //@ maintaining !\result ==> (\forall int i; 0 <= i < \index; calificaciones.get(i).getNota() >= 70);
        for (Calificacion c : calificaciones){
            if (c.getNota() < 70){
                return true;
            }
        }
        return false;
    }
}
