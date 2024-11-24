## Índice

1. [Introducción](#1-introducción)
2. [Manual De Desarrolladores](#2-manual-de-desarrolladores)
3. [Manual de Usuario](#3-manual-de-usuario)
4. [Reparto de tareas](#4-Reparto-de-tareas)
5. [Extras realizados](#5-extras-realizados)
6. [Propuestas de mejora](#6-propuestas-de-mejora)
7. [Conclusión y opinión del trabajo realizado](#7-conclusión-y-opinión-del-trabajo-realizado)




## 1. Introducción

Base de datos sobre objetos del juego Minecraft. Se ha usado como ejemplo para las propiedades de estos, pero no es una base de datos fiel al juego; solo se ha usado para tener una base para desarrollar el ejercicio.

La base de datos se ha diseñado teniendo en mente el uso de un esquema de especializacion, o "Es un". Dónde un item puede ser un libro, una herramienta, una poción o un bloque.

![diagrama1.png](src%2Fmain%2Fresources%2Fimagenes%2Fdiagrama1.png)

Las propiedades de las tablas son las siguientes:

#### Items
- ItmId INT AUTO_INCREMENT NOT NULL
- ItmName VARCHAR(40) NOT NULL
- ItmDesc TEXT NOT NULL
- ItmStackSize INT NOT NULL
- ItmImage BLOB

#### Blocks
- BlkId INT NOT NULL,
- BlkIdName VARCHAR(30) NOT NULL
- BlkLuminosity INT NOT NULL
-  BlkBlastResistance INT NOT NULL
- BlkFlammable INT NOT NULL

#### Tools
- ToolId INT NOT NULL,
- ToolName VARCHAR(30) NOT NULL
- ToolDurability INT NOT NULL
- ToolFlammable INT NOT NULL
- ToolDamage FLOAT NOT NULL

#### Books
- BkId INT NOT NULL AUTO_INCREMENT
- BkName VARCHAR(50) NOT NULL
- BkType ENUM('Normal', 'Encantado', 'Escrito') NOT NUL
- BkEnchantment VARCHAR(50)
- BkLevel TINYINT NOT NULL

#### Potions
- PotId INT NOT NULL AUTO_INCREMENT
- PotName VARCHAR(40) NOT NULL
- PotEffect TEXT NOT NULL
- PotDuration INT NOT NULL
- PotLevel TINYINT NOT NULL

![diagrama2.png](src%2Fmain%2Fresources%2Fimagenes%2Fdiagrama2.png)

## 2. Manual De Desarrolladores

#### Las caracteristicas del proyecto son:
- Logearse en la aplicación usando usuarios que estén registrados.
- Mostrar un item válido y consecuentemente su tipo, caracteristicas y demás.
- Exportar la información del objeto buscado a JSON
- CRUD+ con diferentes objetos:
    - Mostrar los objetos de diferentes maneras
    - Eliminar un item de manera recursiva
    - Modificar el tipo de item
    - Crear un item básico
    - Especializar un item básico a uno específico

![arquitecturaHumana.png](src%2Fmain%2Fresources%2Fimagenes%2FarquitecturaHumana.png)

Las clases/metodos que componen las funcionalidades anteriores son las siguientes:

![arquitecturaLogica.png](src%2Fmain%2Fresources%2Fimagenes%2FarquitecturaLogica.png)


##### Arquitectura del proyecto:

Se ha usado el patrón MVC (Modelo, Vista, Controlador) dónde cada responsabilidad de las clases se encapsula con su deber. De este modo la arquitectura es la siguiente:

![mcv.png](src%2Fmain%2Fresources%2Fimagenes%2Fmcv.png)

##### Como obtener el proyecto

Moverse y Crear una carpeta en el escritorio dónde guardar el proyecto, para que no esté directamente en el escritorio. Se requiere tener instalado [Git](https://git-scm.com) en el sistema.
```
$cd Desktop
$mkdir proyectoMCItems
$cd proyectoMCItems
$git clone https://github.com/AmarinoLama/proyectoUD2Minecraft
```
Una vez descargado, podremos acceder al proyecto dentro del escritio, en la carpeta que hemos creado.

## 3. Manual de Usuario

Las diferentes funcionalidades de la aplicación pueden ser accedidas tras pasar del login con los usuarios:

evan - abc

aman - 1234

administrador - renaido

![login.png](src%2Fmain%2Fresources%2Fimagenes%2Flogin.png)

Tras eso se puede acceder al "Hall" de la aplicación, la ventana principal donde pueden visualizarse datos, en esta ventana tenemos dos sub-ventanas con las que interacturar, asi como explotar o salir de la aplicación.

![main1.png](src%2Fmain%2Fresources%2Fimagenes%2Fmain1.png)

Además, podemos hacer un filtrado mas exhaustivo sobre la base de datos.

![filtradoespecifico.png](src%2Fmain%2Fresources%2Fimagenes%2Ffiltradoespecifico.png)

También podemos indagar para añadir, eliminar modificar o asignar objetos si clickamos en "Acción"

![main2.png](src%2Fmain%2Fresources%2Fimagenes%2Fmain2.png)

![anadirdatos.png](src%2Fmain%2Fresources%2Fimagenes%2Fanadirdatos.png)

![borrardatos.png](src%2Fmain%2Fresources%2Fimagenes%2Fborrardatos.png)

![asignaritem.png](src%2Fmain%2Fresources%2Fimagenes%2Fasignaritem.png)

![modificaritem.png](src%2Fmain%2Fresources%2Fimagenes%2Fmodificaritem.png)

Todas las pantallas tienen hints o ayudas para saber lo que escribir en caso de duda, la mayoria de veces hay que seleccionar que tipo de objeto hya que modificar a qué para que aparezcan estas ayudas.

## 4. Reparto de tareas

Dado que en el proyecto anterior Amán hizo gran parte del código, en este proyecto nos hemos centrado más en dividir las tareas. Siendo que Aman, se centró en la parte de conectar la aplicación con las ventana ed javaFX y el CRUD más específico, es decir, las ventanas del "SELECT", "UPDATE", "DELETE" e "INSERT".

Para ser más específicos, las clases que hemos realizado conjuntamente son:

- Conexion (abrirConexion, cerrarConexion y los primeros métodos de insertar datos)
- MainController
- Main
- Main.fxml
- Todas las clases de los Objetos (Items, Books, Blocks, Potions y Tools)
- BBDD hacer tablas

Las clases que ha realizado Evan son las siguientes:

- LoginController
- ExportJSONController
- Estilos internos de los fxml
- Meterle datos a las tablas de ambas BBDD

Las clases que ha realizado Aman son las siguientes:

- AnadirDatosController
- AsignarDatosController
- DeleteDatosController
- ModificarItemsController
- OrdenarController
- Conexion (respectivos métodos llamados en las clases anteriores)
- Tipo enumerado de la tabla Libro
- Alertas
- Casos test
- styles.css
- Los fxml de las clases mencionadas anteriormente

## 5. Extras realizados

Al comenzar el proyecto decidimos realizar los extras del login (junto a guardar los datos en una base de datos externa y hashear las contraseñas) y el control de errores, pero con el desarrollo del programa nos hemos percatado de que inconscientemente también hemos hecho el extra de ordenación de resultados. Ahora desarrollaremos más ha fondo lo que hemos codificado en cada extra:

#### Ordenación de resultados de las consultas y almacenaje de los datos

Respecto a este extra lo que hemos hecho, se ha basa en crear un botón que sirva para filtrar los datos de la tabla actual, en este caso solo lo implementamos en la de items debido a que no teniamos mucho tiempo.

Gracias a este botón este usuario puede tomar la decesión de ordenar los datos de la tabla según la columna que desee, esto quiere decir, que el usuario puede querer ordenar por la descripción, por el nombre, el tamaño del stack o mismamente por la url, teniendo siempre una opción marcada por defecto que es la de ordenar por ID.

Paralelamente a las ordenaciones también hemos añadido una opción para filtrar los datos según tres características distintas y estas son:

- Quedarse únicamente con los items que tengan un stack igual o superior a 64
- Separar los items que tengan un nombre formado con una sola palabra
- Mostrar todos los items que su descripción tenga más de 30 letras

Para gestionar todo esto, creamos una función privada que se encargue de construir la query necesaria para obtener los datos filtrados. Esta query se divide en dos partes, la primera en la que se forman los "ORDER BY" y la segunda en la que se añaden las sentencias "WHERE" que en el caso de que haya más de una sentencia seleccionada se juntaran con "AND".

Si deseas visualizar la imagen de como se ve la ventana en ejecución haz click aquí.

#### Control de errores

Para realizar este extra nos hemos centrado principalmente en poner un montón de try catchs en los métodos que podían lanzar cualquier tipo de excepción. Una vez puesto el controlador de errores añadimos que cada vez que suceda algo correctamente salga una ventana emergente informativa con un mensaje conforme la acción se había realizado correctamente y cuando había algo que no salía bien se mostraba una ventana de error explicando los posibles fallos que pudieron originar esa excepción.

Por otra parte, a la hora de ejecutar querys que hagan actualizaciones en la base de datos siempre hemos inicializado una variable con el número de líneas modificadas para controlar si se ha ejecutado todo correctamente o ha sucedido algún error. Al controlar esas varibles es mucho más sencillo identificar el tipo de problema por lo que la alerta que se lanza tendrá un mensaje más significativo, como por ejemplo en la clase de modificar que te pone "Tienes que rellenar todos los campos para poder realizar la modificación" o "Revisa los tipos de datos, ya que alguno seguramente sea un número".

Independientemente a todo lo anterior, también hemos realizado casos test para las clases que podían ser testeadas, que en este caso son "Model/Conexion.java" y "Controller/LoginController.java".

- En la clase LoginControllerTest se han creado test para ver como actua el programa ante los distintos casos:
- Comprobar un usuario bien con su respectiva contraseña
- Comprobar un usuario bien con una contraseña mal
- Comprobar un usuario mal con una contraseña mal

- En la clase ConexionTest se han creado casos test para los siguientes métodos:
- Comprobar el método de `obtenerColumnasTabla()` con un caso en el que se le pasa una tabla existente y otro con una tabla inexistente
- Comprobar el método de  `cargarItemsFiltrados() ` con una query mala y otra buena
- Comprobar todos los métodos de  `cargarTabla() ` con la tabla correspondiente para ver si devuelve algo
- Comprobar el método de `insertarDatos()` con datos bien y datos mal
- Comprobar el método de `borrarDatos()` con datos bien y datos mal
- Comprobar el método de `asignarItem()` con datos bien y datos mal
- Comprobar el método de `cargarDatosObjeto()` con existentes y otros inexistentes
- Comprobar el método de `modificarObjeto()` con datos existentes y otros no

#### Login

El extra de login consiste en un login dónde los datos se almacenan en una base da datos independiente, la cual contiene una ID, un nombre de usuario y su respectiva contraseña hasheada.

## 6. Propuestas de mejora

No nos hemos encontrado con muchos problemas a lo largo del desarrollo de esta aplicación por lo que no tenemos muchas cosas que haya que refinar además de los estilos de la aplicación, pero eso no quita que no se puedan añadir nuevas funcionalidades a la aplicación como bien pueden ser el caso de implementar los siguientes métodos:

- Poder usar el Jar
- Poder filtrar en todas las tablas, en vez de hacerlo únicamente en la tabla de items
- Implementar un desplegable para seleccionar dónde exportar el json para que sea más entendible y fácil de usar para el cliente
- Añadir un atajo para cuando le deas doble click en una dato ya se habra la ventana de modificar datos con todo cargado
- Añadir un atajo para cuando le deas click derecho puedas borrar el dato
- Implementar más tablas
- Permitir al usuario crear más reglas para filtrar los datos
- Hacer que se carguen las reglas actuales al abrir la opción de filtrar datos
- Poder elegir si ordenar en sentido ascendente o descendente
- Añadirle un MenuBar para poder salir, exportar, iniciar sesión, ...

En resumen los cambios más relevantes que se podrían hacer para la aplicación se centran en darle más libertad al usuario a la hora de manejar los datos y poder tener más privilegios (a la hora de poder crear nuevas reglas de filtrado), además de hacer el programa más simple e intuitibo ya sea usando más ventanas emergentes con preguntas tipo "¿Desea modificar o borrar este dato?". A pesar de todas estas posibles mejoras creemos que nuestro programa cumple todos los requisitos y es perfectamente comprensible ante cualquier usuario.

## 7. Conclusión y opinión del trabajo realizado

Este proyecto nos ha parecido propuesta de ejercicio bastante interesante y sencillo, dado que al tener ya los suficientes conocimientos en javaFX nos ha resultado muy fácil el desarrollo de esta app y no nos hemos estancado en ningún momento. Así mismo, la conexión con la BBDD y usar el patrón MVC (Model View Controllator) tampoco nos ha dado muchos problemas por lo que podemos decir que estamos bastante satisfechos con nuestro programa.

Por otra parte, cabe destacar que en cuanto estilos de la aplicación son bastante simples y podríamos haber añadido más imágenes de decoración entre otras cosas, pero hemos optado por centrarnos más en pulir nuestro programa implementando más funciones como en el caso de filtrar los datos.

Cabe destacar, que nuestro mayor problema al desarrollar esta aplicación fue poder usar el JAR, dado que fuimos capaces de crearlo correctamente pero a la hora de ejecutarlo no debajamos de sufrir error tras error.

Finalmente, respecto a las horas dedicadas hemos dedicado 18 horas en clase y a mayores 10 más desde nuestras casas, por lo que esto en total suman 28 horas a repartir entre los dos.  La nota que creemos que podría tener nuestro trabajo es de un 8´5, ya que hemos realizado todos los extras y solo tenemos un margen de error de 1´5 de errores que podemos tener en cuanto a la estructura del código.