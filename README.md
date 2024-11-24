## Introducción

Base de datos sobre objetos del juego Minecraft. Se ha usado como ejemplo para las propiedades de estos, pero no es una base de datos fiel al juego; solo se ha usado para tener una base para desarrollar el ejercicio.

La base de datos se ha diseñado teniendo en mente el uso de un esquema de especializacion, o "Es un". Dónde un item puede ser un libro, una herramienta, una poción o un bloque.

[INSERTAR AQUI EL DIAGRAMA]

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

## Manual De Desarrolladores

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

## Manual de Usuario

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