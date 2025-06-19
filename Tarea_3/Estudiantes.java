
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Estudiantes {  
    String nombre;
    int carnet;
    HashSet<String> cursos = new HashSet<>();
    static HashMap<Integer, Estudiantes> estudiantesCarnets = new HashMap<>();

    // constructor
    // Al ser cursos un HashSet no puede tener cursos repetidos
    // Con el HashMap de estudiantesCarnets se comprueba que los carnets sean unicos
    public Estudiantes(String nombre,int carnet, String[] cursos){
        
        //@ requires nombre.length > 2 && carnet >= 0 && cursos != null;
        if(estudiantesCarnets.containsKey(carnet) || carnet < 0 || nombre.length() < 2 || cursos == null){
            throw new IllegalArgumentException("Los parametros para registrar un estudiante son invalidos");
        }
        this.nombre = nombre;
        this.carnet = carnet;
        this.cursos.addAll(Arrays.asList(cursos));
        estudiantesCarnets.put(carnet, this);
    }
}

