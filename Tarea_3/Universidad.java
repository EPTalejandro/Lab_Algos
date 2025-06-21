import java.util.ArrayList;

public class Universidad{

    //Crea un nuevo objeto Estudiante que representa un estudiante
    public static void añadirEstudiante(String nombre,Integer carnet,String[] cursos){
        Estudiantes estudiante = new Estudiantes(nombre,carnet,cursos);
        Estudiantes.getEstudiantesCarnets().put(carnet, estudiante);
    }

    //Dado un curso y un estudiante se inscribe ese estudiante al curso
    public static void añadirACurso(String curso,int carnet){
        //@ requires curso != null;
        //@requires carnet > 0;
        if( curso == null){
            throw new IllegalArgumentException("El curso a registrar no puede ser nulo");
        }
        else if(carnet < 0){
            throw new IllegalArgumentException("El carnet no puede ser menor a cero");
        }
        Estudiantes.getEstudiantesCarnets().get(carnet).addCurso(curso);
    }

    // Dado el carnet de un estudiante lista todos sus cursos
    public static void cursosEstudiante(int carnet){
        //@requires carnet > 0 ;
        if(carnet < 0){
            throw new IllegalArgumentException("El carnet no puede ser menor a cero");
        }
        else if(Estudiantes.getEstudiantesCarnets().containsKey(carnet)==false){
            throw new IllegalArgumentException("El carnet " + carnet + " no existe");
        }
        else{
            System.out.println("El estudiante "+ Estudiantes.getEstudiantesCarnets().get(carnet).getNombre() + " esta inscrito en los siguientes cursos: " + Estudiantes.getEstudiantesCarnets().get(carnet).getCursos());
        }
    }

    // Dado un carnel de un alumno y un curso verifica si el alumno esta inscrito en ese curso
    public static void alumnoInscritoCurso(String curso,int carnet){
        //@ requires curso != null;
        //@ requires carnet > 0;
        if( curso == null){
            throw new IllegalArgumentException("El curso a revisar inscripcion no puede ser nulo");
        }
        else if(carnet < 0){
            throw new IllegalArgumentException("El carnet no puede ser menor a cero");
        }
        else if(Estudiantes.getEstudiantesCarnets().get(carnet).getCursos().contains(curso)){
            System.out.println("El estudiante " + Estudiantes.getEstudiantesCarnets().get(carnet).getNombre() + " sí está inscrito en " + curso);
        }
        else{
            throw new IllegalArgumentException("El estudiante " + Estudiantes.getEstudiantesCarnets().get(carnet).getNombre() + " no esta inscrito en " + curso);
        }
    }
    
    // Muestras los alumnos inscritos en un curso dado
    public static void inscritosEnCurso(String curso){
        //@ requires curso != null;
        if( curso == null){
            throw new IllegalArgumentException("El curso a revisar inscripcion no puede ser nulo");
        }
        ArrayList<String> estudiantesInscritos = new ArrayList<>();

        for(Estudiantes estudiante: Estudiantes.getEstudiantesCarnets().values()){
            if(estudiante.getCursos().contains(curso)){
                estudiantesInscritos.add(estudiante.getNombre());
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
        //@ ensures curso == (\sum Estudiantes estudiante; Estudiantes.getEstudiantesCarnets().values() ; 1)
        if( curso == null){
            throw new IllegalArgumentException("El curso a contar no puede ser nulo");
        }
        int total = 0;
        for(Estudiantes estudiante: Estudiantes.getEstudiantesCarnets().values()){
            if(estudiante.getCursos().contains(curso)){
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

