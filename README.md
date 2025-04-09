[![Scanner QR](https://sdmntprsouthcentralus.oaiusercontent.com/files/00000000-fde4-51f7-baf9-c1e5594b81a9/raw?se=2025-04-09T04%3A05%3A02Z&sp=r&sv=2024-08-04&sr=b&scid=b290cf52-6bf4-52a9-badc-384bcaa861c1&skoid=365eb242-95ba-4335-a618-2c9f8f766a86&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2025-04-08T22%3A34%3A46Z&ske=2025-04-09T22%3A34%3A46Z&sks=b&skv=2024-08-04&sig=aPpxlX5z4sWRAnq2Kpe20dO7dNJpVGUo/lkaaUY1zdE%3D "Scanner QR")](https://sdmntprsouthcentralus.oaiusercontent.com/files/00000000-fde4-51f7-baf9-c1e5594b81a9/raw?se=2025-04-09T04%3A05%3A02Z&sp=r&sv=2024-08-04&sr=b&scid=b290cf52-6bf4-52a9-badc-384bcaa861c1&skoid=365eb242-95ba-4335-a618-2c9f8f766a86&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2025-04-08T22%3A34%3A46Z&ske=2025-04-09T22%3A34%3A46Z&sks=b&skv=2024-08-04&sig=aPpxlX5z4sWRAnq2Kpe20dO7dNJpVGUo/lkaaUY1zdE%3D "Scanner QR")


#Sistema de Verificación de Transporte (SVT)

Sistema que mejora la seguridad ciudadana mediante la obtención de datos de conductores y vehículos de transporte público, permitiendo a los usuarios verificar información a través del escaneo de códigos QR para facilitar el cuidado personal al usar servicios de transporte.

###Comenzando 🚀
Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Mira Despliegue para conocer cómo implementar el proyecto en un entorno de producción.

###Pre-requisitos 📋

Para instalar y ejecutar este software necesitas:

- Sistema operativo Windows
- 16GB RAM DDR4
- 30GB de espacio en disco
- Procesador compatible con arquitectura de 32bits
- Conexión a internet (Wi-Fi)
- Java Development Kit (JDK) 8 o superior

### Verifica tu versión de Java
java -version

###Instalación 🔧

Sigue estos pasos para configurar tu entorno de desarrollo:

1. Clona el repositorio

 git clone https://github.com/tuusuario/sistema-verificacion-transporte.git

2. Importa el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.)

##### Si usas Maven
mvn clean install 

3. Configura la conexión a la base de datos SQL Server en el archivo de configuración

Ejemplo de configuración en application.properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=svt_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

7. Ejecuta la aplicación. 

##### Ejecutar desde la clase principal
java -jar svt-app.jar

###Uso del sistema 💻

1. Regístrate con tus datos personales (nombre completo, correo, número de teléfono y contraseña).
2. Inicia sesión en el sistema.
3. Utiliza la función de escaneo para leer los códigos QR de los vehículos.
4. Visualiza la información del conductor y vehículo (matrícula, nombre, modelo, etc.)
5. Consulta tu historial de escaneos.
