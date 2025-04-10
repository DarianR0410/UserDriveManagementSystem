![ScannerQR Minimalista (1)](https://github.com/user-attachments/assets/20fa330b-c145-48de-a7db-d54ecebd815a)

# Sistema de Verificación de Transporte (SVT)

Sistema que mejora la seguridad ciudadana mediante la obtención de datos de conductores y vehículos de transporte público, permitiendo a los usuarios verificar información a través del escaneo de códigos QR para facilitar el cuidado personal al usar servicios de transporte.

### Comenzando 🚀
Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Mira Despliegue para conocer cómo implementar el proyecto en un entorno de producción.

### Pre-requisitos 📋

Para instalar y ejecutar este software necesitas:

- Sistema operativo Windows
- 16GB RAM DDR4
- 30GB de espacio en disco
- Procesador compatible con arquitectura de 32bits
- Conexión a internet (Wi-Fi)
- Java Development Kit (JDK) 8 o superior

### Verifica tu versión de Java
java -version

### Instalación 🔧

Sigue estos pasos para configurar tu entorno de desarrollo:

1. Clona el repositorio

 git clone https://github.com/tuusuario/sistema-verificacion-transporte.git

2. Importa el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.)

**Si usas Maven**
mvn clean install 

3. Configura la conexión a la base de datos SQL Server en el archivo de configuración

Ejemplo de configuración en application.properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=svt_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

4. Ejecuta la aplicación. 

**Ejecutar desde la clase principal**
java -jar svt-app.jar

### Uso del sistema 💻

1. El sistema cuenta con dos tipos de usuarios principales: **Pasajeros y Conductores**, cada uno con su propio flujo de registro y el mimso inicio de sesión.

Para cambiar de registro entre Pasajero y Conductor se utiliza el siguiente boton el cual funciona como un switch.

![image](https://github.com/user-attachments/assets/dcdad72a-b633-431f-8879-a2358eda8a6a)


**Registro del Pasajero 🙋‍♂️**

La pantalla de registro de pasajero tiene un diseño con fondo morado osucuro y muestra un formulario con los siguientes campos:(Nombre, Apellido, Correo, Número de teléfono y Contraseña).

![image](https://github.com/user-attachments/assets/2efc14fe-a43b-45ce-af76-02407afe19a8)

También incluye un enlace "¿Ya tienes una cuenta? Iniciar sesión" en la parte inferior y un botón "Registrar" para completar el proceso.

**Registro del Conductor 🚘🚖**

La pantalla de registro de conductor tiene un diseño con fondo morado claro y muestra un formulario con los siguientes campos:(Nombre, Apellido, Correo, Número de teléfono, Contraseña) y tambien información del vehículo con los siguientes campos: (Placa, Marca, Modelo, Año Color).

 ![image](https://github.com/user-attachments/assets/3d33e0fd-4047-4aba-82d4-f79ae8dce765)

Incluye el mismo enlace para iniciar sesión y un botón "Registrar" de color morado claro.

2. Inicia sesión en el sistema.

![image](https://github.com/user-attachments/assets/1ddcb50e-d71c-484f-859e-087cf6db7c2b)

3. Utiliza la función de escaneo para leer los códigos QR de los vehículos.
4. Visualiza la información del conductor y vehículo (matrícula, nombre, modelo, etc.)
5. Consulta tu historial de escaneos.

### Ejecutando las pruebas ⚙️

Para ejecutar las pruebas automatizadas del sistema:

**Si usas Maven**
mvn test

### Pruebas de integración 🔩

Estas pruebas verifican que los componentes del sistema funcionen correctamente entre sí:

**Ejecutar solo pruebas de integración**
mvn integration-test

**Pruebas de escaneo de QR ⌨️**
Verifican que el sistema pueda escanear y procesar correctamente los códigos QR:

**Ejemplo de prueba de escaneo**
mvn test -Dtest=QRScannerTest

### Despliegue 📦

Para desplegar el sistema en un entorno de producción:

1.	Configura un servidor con los requisitos necesarios.
2.	Establece la conexión a la base de datos de producción.
3.	Genera el archivo JAR ejecutable.
4.	Configura el sistema como un servicio para que se inicie automáticamente.

### Construido con 🛠️
- Java - Lenguaje de programación principal.
- Java Swing - Biblioteca gráfica para la interfaz.
- SQL Server - Sistema de gestión de bases de datos.

### Autores ✒️
-	[Darian Elizabeth Ramos Estepan] - Desarrollo Backend.
-	[Joslam Jerez Perez] - Desarrollo Frontend.
-	[Angel Isaac Mejia Martinez] - Desarrollo Frontend.
-	[Ashley Michel Cabrera Mena] - Scrum Master.
-	[Daniel Nicolas Volquez Jimenez] - Base de datos.
-	[Cristopher Jose Antonio Duran Taveras] - Análisis y Diseño.
