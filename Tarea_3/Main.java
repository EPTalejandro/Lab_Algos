

public class Main{
     public static void main(String[] args){
        Estudiantes estudiante1 = new Estudiantes("Juan Perez", 12345, new String[]{"Matematicas", "Fisica"});
        Estudiantes estudiante2 = new Estudiantes("Maria Lopez", 67890, new String[]{"Quimica", "Biologia", "Matematicas"});
        estudiante1.añadirACurso("Informatica");
        System.out.println(estudiante1.cursosEstudiante(12345));
        
        System.out.print(Estudiantes.cursosEstudiante(12345));
        estudiante1.inscritoCurso("Matematicas");
        estudiante1.carnet();
        System.out.println("En matematicas hay inscritos: " + Estudiantes.estudiantesPorCurso("Matematicas")+ " alumnos ");
        System.out.println("los estudiantes inscritos en Quimica son: " + Estudiantes.inscritosEnCurso("Quimica"));
        //System.out.println(estudiante1.estudiantesCarnets);
        //estudiante2.inscritoCurso("Historia"); // Esto lanzará una excepción
    }
}