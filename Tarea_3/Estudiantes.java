
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Estudiantes {  
    private String nombre;
    private int carnet;
    private final HashSet<String> cursos = new HashSet<>();
    private static final HashMap<Integer, Estudiantes> estudiantesCarnets = new HashMap<>();

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
    }

    public static HashMap<Integer, Estudiantes> getEstudiantesCarnets(){
        return estudiantesCarnets;
    }

    public HashSet<String> getCursos(){
        return this.cursos;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void addCurso(String curso){
        this.cursos.add(curso);
    }

    public int getCarnet() {
        return this.carnet;
    }

}

