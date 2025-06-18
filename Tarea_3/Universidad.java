import java.util.ArrayList;
import java.util.HashSet;

public class Universidad{

    //Crea un nuevo objeto Estudiante que representa un estudiante
    public static void añadirEstudiante(String nombre,int carnet,String[] cursos){
        new Estudiantes(nombre,carnet,cursos);
    }

    //Dado un curso y un estudiante se inscribe ese estudiante al curso
    public static void añadirACurso(String curso,int carnet){
        //@ requires curso != null;
        //@requires estudiante != null;
        Estudiantes.estudiantesCarnets.get(carnet).cursos.add(curso);
    }

    // Dado el carnet de un estudiante lista todos sus cursos
    public static HashSet<String> cursosEstudiante(int carnet){
        //@requieres carnet != null;
        if(Estudiantes.estudiantesCarnets.containsKey(carnet)==false){
            throw new IllegalArgumentException("El carnet " + carnet + " no existe");
        }
        else{
            return Estudiantes.estudiantesCarnets.get(carnet).cursos;
        }
    }

    // Dado un carnel de un alumno y un curso verifica si el alumno esta inscrito en ese curso
    public static void alumnoInscritoCurso(String curso,int carnet){
        //@ requires curso != null;
        //@ requires carnet != null;
        if(Universidad.cursosEstudiante(carnet).contains(curso)){
            System.out.println("El estudiante " + Estudiantes.estudiantesCarnets.get(carnet).nombre + " sí está inscrito en " + curso);
        }
        else{
            throw new IllegalArgumentException("El estudiante " + Estudiantes.estudiantesCarnets.get(carnet).nombre + " no esta inscrito en " + curso);
        }
    }
    
    // Muestras los alumnos inscritos en un curso dado
    public static void inscritosEnCurso(String curso){
        //@ requires curso != null;
        ArrayList<String> estudiantesInscritos = new ArrayList<>();

        for(Estudiantes estudiante: Estudiantes.estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                estudiantesInscritos.add(estudiante.nombre);
            }
        }
        if(estudiantesInscritos.isEmpty()){
            System.out.println("No hay alumnos inscritos en "+ curso);
        }
        else if (estudiantesInscritos.size() == 1) {
            System.out.println("El alumno inscrito en el curso de "+ curso + " es " + estudiantesInscritos);
        }
        else{
            System.out.println("Los alumnos inscritos en el curso de "+ curso + " son " + estudiantesInscritos);
        }
        
    }

    // cuenta el numero de estudiantes inscritos en un curso
    public static void estudiantesPorCurso(String curso){
        //@ requires curso != null;
        int total = 0;
        for(Estudiantes estudiante: Estudiantes.estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                total = total + 1;
            }
        }
        if(total > 1){
            System.out.println("En " + curso + " hay " + total + " inscritos");
            }
        else if(total == 1){
            System.out.println("En " + curso + " hay 1 inscrito");
        }
        else{
            System.out.println("En " + curso + " no hay inscritos");
        }

        }
}

