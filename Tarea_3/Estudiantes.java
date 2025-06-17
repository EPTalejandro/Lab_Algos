
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Estudiantes {  
    String nombre;
    int carnet;
    HashSet<String> cursos = new HashSet<>();
    static HashMap<Integer, Estudiantes> estudiantesCarnets = new HashMap<>();

    public Estudiantes(String nombre,int carnet, String[] cursos){
        
        //@ requires nombre != null && carnet >= 0 && cursos != null;
        if(estudiantesCarnets.containsKey(carnet) || carnet < 0 || nombre.length() < 2 || cursos == null){
            throw new IllegalArgumentException("El carnet " +carnet + " ya esta en uso");
        }
        this.nombre = nombre;
        this.carnet = carnet;
        this.cursos.addAll(Arrays.asList(cursos));
        estudiantesCarnets.put(carnet, this);
    }

    public void añadirACurso(String curso){
        //@ requires curso != null;
        this.cursos.add(curso);
    }

    public static HashSet<String> cursosEstudiante(int carnet){

        if(estudiantesCarnets.containsKey(carnet)==false){
            throw new IllegalArgumentException("El carnet " + carnet + " no existe");
        }
        else{
            return estudiantesCarnets.get(carnet).cursos;
        }
    }

    public void inscritoCurso(String curso){
        //@ requires curso != null;
        if(this.cursos.contains(curso)){
            System.out.println("El estudiante " + this.nombre +" sí está inscrito en " +curso);
        }
        else{
            throw new IllegalArgumentException("El estudiante "+ this.nombre +" no esta inscrito en "+ curso);
        }
    }

    public static HashSet inscritosEnCurso(String curso){

        HashSet<String> estudiantesInscritos = new HashSet<>();

        for(Estudiantes estudiante: estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                estudiantesInscritos.add(estudiante.nombre);
            }
        }
        return estudiantesInscritos; 
    }

    public static int estudiantesPorCurso(String curso){
        //@ requires curso != null;
        int total = 0;
        for(Estudiantes estudiante: estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                total++;
            }
        }
        return total;
    }

    public void  carnet(){
        System.out.println("El estudiante "+this.nombre+" tiene el carnet: "+this.carnet); 
    }
}

