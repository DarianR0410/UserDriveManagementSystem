![ScannerQR Minimalista](https://github.com/user-attachments/assets/62bf00a8-c3a6-4679-8937-67cc066c3287)

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

1. Regístrate con tus datos personales (nombre completo, correo, número de teléfono y contraseña).
2. Inicia sesión en el sistema.
3. Utiliza la función de escaneo para leer los códigos QR de los vehículos.
4. Visualiza la información del conductor y vehículo (matrícula, nombre, modelo, etc.)
5. Consulta tu historial de escaneos.
