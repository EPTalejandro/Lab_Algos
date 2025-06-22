Explicacion modulos SIGU

Estudiantes y Universidad:
    - Primero, la clase Estudiantes la cual creara los objetos que representan a los diferentes estudiantes, estos tienen 3 atributos unicos(nombre,cursos,carnet)
    y un atributo al cual todos puden acceder que es estudiantesCarnet, el cual se utiliza para hacer busquedas de manera rapida a traves del carnet facilitando
    la busqueda de usuarios y eliminando la necesidad de almacenar los objetos en variables. la funcion cuenta con diferentes metodos para retribuir cada
    atributo y uno para añadir estudiantes  
    
    - Acompañando a esta esta la clase Universidad la cual se encarga de las diferentes operaciones solicitadas para los objetos estudiantes 
    cuenta con diferentes metodos
    *añadirEstudiante: recibe los diferentes argumentos de un estudiante y lo crea ademas de añadirlo a estudiantesCarnet
    *añadirACurso: Dado un curso y el carnet de un estudiante añade a dicho estudiante en el curso dado 
    *cursosEstudiante: Muestra la lista de todos los cursos que esta cursando un estudiante dado su carnet 
    *alumnoInscritoCurso: Dado un carnet y un curso verifica si dicho estudiante esta inscrito en ese curso
    *inscritosCurso: Imprime la lista de todos los alumnos inscritos en un curso dado 
    *estudiantesPorCurso: Muestra el total de alumnos inscritos en un curso

    Este modulo se maneja directamente utilizando los metodos de la clase Universidad sin necesidad de guardar los objetos Estudiantes en variables

Productos y Inventario:
    - La clase productos cuenta con 3 atributos(nombre,precio,cantidad) como atributos unicos y un atributo compartido por todos que es una lista
    que guarda todos los productos listados la cual servira para iterar mas tarde sobre ella, productos cuenta con metodos para retribuir atributos 
    y actulizar la cantidad de un producto 

    -La clase inventario nuevamente maneja todo el modulo sin necesidad de crear variables para contener los objetos de tipo productos, a traves de diferentes
    metodos: 
    *añadirProducto: Se le pasan los diferentes argumentos esperados para crear un nuevo producto y lo añade tambien a la lista de productos 
    *actulizarCantidad: Dado un numero positivo o negativo dependiendo de si se quiere reponer o restar unidades se actuliza la cantidad del producto
    *listarProductos: Muestra la lista de todos los productos registrados
    *valorInventario: Muestra el valor TOTAL de el inventario de todos los productos y todas sus unidades disponibles
    *productosAgotados: Devuelve la lista de todos los objetos que estan agotados
    *mayorValorTotal: Devuelve el producto con mayor valor acumulado entre todas sus unidades por valor unitario 
    *productoMasCaro: Da el producto con mayor valor unitario de todos los productos registrados  

Calificacion y AnalisisCalificacion:
    -En primer lugar, tenemos la clase Calificacion la cual crea objetos que representan la nota de un estudiante, cada instancia crea dos atributos únicos:
    -nombre y nota:  nombre es un String que no puede ser nulo ni vacio, mientras que nota es un int que se encuentra en el rango entre 0 y 100.
    -getNombre y getNota: cada uno devuelve su correspondiente nombre o nota.
    Además, para facilitar la depuración se sobreescribe toString() que imprime el formato “Nombre (nota)” en lugar del hash por defecto.

    -Acompañada a esta se encuentra la clase AnalisisCalificacion la cual mantiene una lista privada que se encarga de almacenar todas las calificaciones añadidas. No es necesario almacenar objetos Calificacion en variables externas, solo basta con llamar a sus métodos. Estos métodos son:
    *agregar(int nota, String nombre): crea una nueva calificación con la validación correspondiente y lo añade a la lista.
    *notaPromedio(): calcula y devuelve el promedio de todas las nota. Lanza excepción si la lista está vacia.
    *obtenerMejorEstudiante(): recorre la lista y devuelve el nombre y la nota del estudiante con la mayor calificación en el formato “Nombre (nota)”.
    *estudiantesReprobados(): devuelve los nombres de los estudiantes con notas por debajo de 70.
    *contarReprobados(): cuenta cuantas notas están por debajo de 70 y devuelve el número.
    *superioresA(int valor): devuelve los nombres de los estudiantes con notas mayores al valor asignado en el rango de 0 a 100.
    *hayReprobados(): comprueba si hay notas por debajo de 70, si existen retorna true, si no hay notas por debajo de 70 entonces retorna false.
    
    Prueba rápida:
    Para compilar ambas clases utilice: javac Calificacion.java AnalisisCalificacion.java
    
    Crea un main o utiliza un programa de prueba para llamar a los métodos de AnalisisCalificacion.java:

    public static void main(String[] args){

        AnalisisCalificacion ac = new AnalisisCalificacion();

        ac.agregar(new Calificacion("María", 50));
        ac.agregar(new Calificacion("Luis", 75));
        ac.agregar(new Calificacion("Ana", 20));
        ac.agregar(new Calificacion("Andrés", 95));
        ac.agregar(new Calificacion("Gabriel", 45));

        System.out.println("Promedio de calificaciones:" + ac.notaPromedio());
        System.out.println("Mejor estudiante:" + ac.obtenerMejorEstudiante());
        System.out.println("estudiantes reprobados (menos de 70):" + ac.estudiantesReprobados());
        System.out.println("Cantidad de estudiantes reprobados:" + ac.contarReprobados());
        System.out.println("Existen reprobados:" + ac.hayReprobados());

        //introducir el valor entre el rango
        Scanner sc = new Scanner(System.in);
        System.err.print("Introduce el valor (0-100) :");
        int valor = sc.nextInt();
        if (valor < 0 || valor > 100){
            System.out.println("Error: el valor está fuera del rango");
        }
            else {
                System.out.println("Estudiantes con notas sobre " + valor + ":" + ac.superioresA(valor));
            }
        sc.close();
    }

