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