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

    -Acompañada a esta se encuentra la clase AnalisisCalificacion la cual mantiene una lista privada que se encarga de almacenar todas las calificaciones
    añadidas. No es necesario almacenar objetos Calificacion en variables externas, solo basta con llamar a sus métodos. Estos métodos son:
    *agregar(int nota, String nombre): crea una nueva calificación con la validación correspondiente y lo añade a la lista.
    *notaPromedio(): calcula y devuelve el promedio de todas las nota. Lanza excepción si la lista está vacia.
    *obtenerMejorEstudiante(): recorre la lista y devuelve el nombre y la nota del estudiante con la mayor calificación en el formato “Nombre (nota)”.
    *estudiantesReprobados(): devuelve los nombres de los estudiantes con notas por debajo de 70.
    *contarReprobados(): cuenta cuantas notas están por debajo de 70 y devuelve el número.
    *superioresA(int valor): devuelve los nombres de los estudiantes con notas mayores al valor asignado en el rango de 0 a 100.
    *hayReprobados(): comprueba si hay notas por debajo de 70, si existen retorna true, si no hay notas por debajo de 70 entonces retorna false.

Ventas y Analisis ventas:
    -Comenzamos con la clase Ventas cuyos objetos tendran tres atributos(producto, precio, cantidad) siendo atributos unicos para cada objeto y la clase 
    Ventas cuenta con diferentes metodos para retribuir dichos elementos
    - Despues esta la clase analisisVentas la cual a pricipio maneja una lista de todas las ventas realizas, luego tiene diferentes metodos que interactuan
    con la clase Ventas con simplemente introducir los nombres de los productos, no es necesario guardar los objetos Ventas en variables para manipularlos
    los metodos de AnalisisVentas son:
    *nuevaVenta: Registra la nueva venta como objeto Venta y lo guarda en la lista de todas las ventas 
    *ingresoProducto: Dado el nombre de un producto Retorna el ingreso total que ha dejado un prodacto tomando en cuenta unidades vendidas y precio unitario
    *ingresoTotal: Devuelme el monto total absoluto de todas las ventas, tomando en cuenta unidades y precio unitario
    *cantidadProducto: Dado un producto retorna la cantidad de este mismo 
    *productoMasVendido: Retorna el producto mas vendido de todos
    *informeProductos: Da un informe detallado de todos los productos su nombre,precio y cantidad
    *productoVendido: Dado un producto indica si este ya a sido vendido o no 
    *cantidadVendida: Retorna el total de unidades vendidas
    *ingresoProductoMayorQue: Retorna todos los productos que hayan dejado un ingreso mayor a una suma dada 
