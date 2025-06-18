

public class Main{
     public static void main(String[] args){
        Universidad.añadirEstudiante("Juan Perez", 12345, new String[]{"Matematicas", "Fisica"});
        Universidad.añadirEstudiante("Maria Lopez", 67890, new String[]{"Quimica", "Biologia"});
        Universidad.añadirACurso("Informatica",12345);
        Universidad.cursosEstudiante(12345);
        
        Universidad.alumnoInscritoCurso("Matematicas",12345);
        Universidad.estudiantesPorCurso("Matematicas");
        Universidad.inscritosEnCurso("Quimica");
        Universidad.inscritosEnCurso("hola");
        //System.out.println(estudiante1.estudiantesCarnets);
        //estudiante2.inscritoCurso("Historia"); // Esto lanzará una excepción
    }
}