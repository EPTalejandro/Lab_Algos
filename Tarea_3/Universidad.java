import java.util.HashSet;

public class Universidad{

    //Dado un curso y un estudiante se inscribe ese estudiante al curso
    public static void añadirACurso(String curso,Estudiantes estudiante){
        //@ requires curso != null;
        //@requires estudiante != null;
        estudiante.cursos.add(curso);
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
            System.out.println("El estudiante " + Estudiantes.estudiantesCarnets.get(carnet) + " sí está inscrito en " + curso);
        }
        else{
            throw new IllegalArgumentException("El estudiante " + Estudiantes.estudiantesCarnets.get(carnet) + " no esta inscrito en " + curso);
        }
    }
    
    // Muestras los alumnos inscritos en un curso dado
    public static void inscritosEnCurso(String curso){
        //@ requires curso != null;
        HashSet<String> estudiantesInscritos = new HashSet<>();

        for(Estudiantes estudiante: Estudiantes.estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                estudiantesInscritos.add(estudiante.nombre);
            }
        }

        System.out.println("Los alumnos inscritos en el "+ curso + " son " + estudiantesInscritos);
    }

    // cuenta el numero de estudiantes inscritos en un curso
    public static void estudiantesPorCurso(String curso){
        //@ requires curso != null;
        int total = 0;
        for(Estudiantes estudiante: Estudiantes.estudiantesCarnets.values()){
            if(estudiante.cursos.contains(curso)){
                total++;
            }
        }
        System.out.println("En: " + curso + " hay " + total + " inscritos");
    }

}