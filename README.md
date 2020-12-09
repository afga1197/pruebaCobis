# Prueba Cobis
Este proyecto fue realizado con el IDE NetBeans 8.2, Java JDK 8, Apache Tomcat 8 y SQL Server 2019 Express. A continuacion se explicara brevemente como debe preparar su ambiente para la ejecucion del programa, con la finalidad de garantizar el correcto funcionamiento del software se sugiere emplear un sistema operativo windows en su version 10 x64.

Las instrucciones que encontrara a continuacion solo son aplicables a sistemas windows, si posee un sistema operativo diferente por favor consulte la pagina del fabricante de la herramienta para mas informacion.

Es importante ejecutar estas instalaciones en la misma secuencia en que se describe cada proceso.
# Instalacion JDK 8
Para la instalacion del JDK 8 debe descargar su instalador desde la pagina del fabricante o en el siguiente enlace https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html. Una vez finalizada la descarga, dar clic derecho y ejecutar como administrador, siga las instrucciones del ejecutable (Es importante recordar la ruta de instalacion ya que posteriormente se empleara).

Una vez finalizada la instalacion, dirijase a inicio y busque "Editar las variables de entorno del sistema", una vez se abra la ventana dar clic en "Variables de entorno", nuevamente se desplegara una ventana. En el apartado de Variables del sistema, dar clic en Nueva. En la ventana que se desplegara colocar en el apartado de Nombre de la variable lo siguiente "JAVA_HOME" y en el apartado de valor de la variable debera colocar la ruta de instalacion de su jdk (es importante colocar la ruta del jdk y no la del jre).

Una vez realizado este proceso en la mismo apartado de Variables del sistema, buscar la variable Path y dar clic en editar. Cuando se despliegue nuevamente la ventana, dar clic en nuevo e ingresar lo siguiente "%JAVA_HOME%\bin".

Finalmente dar clic en aceptar en todas las ventanas que halla abierto, posteriormente abrir un cmd e ingresar "javac -version", debera devolverle la version de java que instalo, si por el contrario le genero error por favor verificar nuevamente el paso a paso o consultar la pagina del fabricante 

# Apache Tomcat 8
Para la instalacion de Tomcat 8 debe descargar el archivo comprimido propocionado por el fabricante, el cual se puede encontrar en el siguiente link https://tomcat.apache.org/download-80.cgi. Una vez descargado, descomprimalo en el directorio de su eleccion (Es importante recordar la ruta ya que posteriormente se empleara)

Posteriormente dirijase a inicio y busque "Editar las variables de entorno del sistema", una vez se abra la ventana dar clic en "Variables de entorno", nuevamente se desplegara una ventana. En el apartado de Variables del sistema, dar clic en Nueva. En la ventana que se desplegara colocar en el apartado de Nombre de la variable lo siguiente "CATALINA_HOME" y en el apartado de valor de la variable debera colocar la ruta en la que descomprimio los archivos Tomcat. A continuacion, en el apartado de Variables del sistema debe seleccionar la variable Path y dar clic en editar, cuando se despliegue la ventana debera dar clic en Nuevo e ingresar lo siguiente "%CATALINA_HOME%\bin". Finalmente debera dar aceptar en todas las ventanas que desplego.

Antes de poder ejecutar el servidor debera configurar el usuario para desplegar aplicativos, para esto debera dirigirse a la carpeta en la cual descomprimio los archivos de Tomcat, despues debera dirigirse a la carpeta conf y abrir el archivo "tomcat-users-xml". Una vez ubicado en el archivo dirijase al final y antes de la etiqueta de cierre "/tomcat-users" debera declara los roles que desea emplear y el usuario con su respectiva contraseña.
Se sugiere lo siguiente "role rolename="manager-gui"" "role rolename="manager-script"" "user username="admin" password="admin" roles="manager-gui,manager-script""

Finalmente despues de guardar los cambios, para desplegar el servidor, en la ruta en la que descomprimio los archivos de Tomcat debe dirigirse a la carpeta bin, alli debera abrir una consola y ejecutar el comando "startup.bat", si el proceso fue exitoso podra acceder a la intefaz del servidor mediante localhost:8080 en su navegador. De lo contrario debera consultar la pagina del fabricante para comprobar los errores que se generan.

# NetBeans

Para la instalacion de netbeans 8.2 se debe descargar el instalador de la version "All" desde la pagina del fabricante o en el siguiente link https://netbeans.org/downloads/old/8.2/. Una vez descargado se debe ejecutar el instalador con permisos de administrador. se debe seguir las instrucciones del iinstaldor sin alterar ninguna opcion (Es importante que la ruta del JDK que se solicita en el proceso sea la misma que la ruta instalada en el principio de esta guia)

Una vez culminado el proceso debera ejecutar el IDE para poder agregar el servidor Tomcat. Para esto dirijase a la pestaña Ventana y haga clic sobre presentaciones, una vez desplegada la ventana, dar clic derecho sobre el apartado de servidores y agregar servidor. Posteriormente debe escoger Apache Tomcat y seguir las instrucciones de asistente (Es importante colocar la ruta de donde descomprimio los archivos Tomcat y el usuario con su respectiva contraseña).

# SQL Server

Para la instalacion de SQL Server se debe descargar desde la pagina del fabricante o en el link https://www.microsoft.com/es-co/download/details.aspx?id=101064. Una vez descargado ejercutarlo y seguir las instrucciones. Antes de cerrar el asistente de instalacion, dar clic en la opcion SSMS, la cual nos redirigira a una pagina de Microsoft en la cual podremos descargar el SSMS.

Una vez finalizado ejecutar el programa y pobra la conexion.

# Aplicacion

Primero debe crear la base de datos, para lo cual puede usar el SSMS para ejecutar el script incluido en el presente proyecto.

Posteriormente debe descargar el archivo zip que genera github, una vez descargado debera abrir NetBeans y en la pestaña de archivo elegir la opcion import project. Seleccione el archivo zip que acabo de descargar desde github y dar clic en import.

Una vez procesado no debera correr el programa (Puede que salgan algunas advertencias, por ahora debera omitirlas), antes de ejecutar el proyecto debera ir a la carpeta en donde Netbeans lo desplego (Si no conoce la ruta puede dar clic derecho sobre el proyecto y propiedasdes) una vez en la carpeta del proyecto debera ingresar a la carpeta "web" y alli crear una nueva carpeta con nombre "WEB-INF".
Finalemente debera regresar a NetBeans y dar clic derecho sobre el proyecto, posteriormente elegir la opcion limpiar y construir. Una vez finalice este proceso podra ejecutar el proyecto (Recuerde usar el servidor Tomcat instalado en el principio)

# Nota

Los nombres de las opciones mencionadas en la presente guia se dieron en español acorde con el idioma predefinido en el sistema empleado, pero puede que algunas opciones cambie de nombre acorde con la configuracion de idioma que halla instalado.


