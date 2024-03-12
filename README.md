# Proyecto Assesment Pragma 2024/03: Cliente

## Descripción general

El **microservicio** llamado ***Cliente (customer)*** es el encargado
de almacenar la información correspondiente a cualquier cliente que se quiera para este
Servicio Financiero
### host: localhost
### port: 8081
### Path: /api/development/v1/finance-service/customers

## Aspectos técnicos

### Lenguaje y framework
Este es un servicio desarrollado en **Java 21** con **Spring Boot 3.2.3** y
gestor de dependencias **Maven**.

### Base de datos
La base de datos se llama H2. La decisión de esta base de datos se debe a su usabilidad simple
y veloz. Para pruebas está más que bien, aun cuando no persiste la data.

### Seguridad
Se realizó una robusta implementación de seguridad a través del uso de **LWT** a través de la librería
*Spring Security* y utilizando cifrado asimétrico **RSA PKCS#8**. La llave pública se dispone en este
servicio, mientras que la clave privada se deja en el servicio consumidor (Postman para pruebas).
El algoritmo utilizado para la generación del JWT fue **RS256**

Para configurar el JWT en Postman se deben seguir los siguientes pasos:
en la pestaña de *Authorization* se debe seleccionar, en *Type* ```JWT Bearer```. Una vez allí,
los campos que salen se deben establecer de la siguiente manera:
* Algorithm: RS256
* Private key: Copiar y pegar todo el contenido de la llave privada, la cual se encuentra en la ruta
*src/main/java/resources/cert/private_key.pem*
* Payload: Se debe configurar el siguiente json:
    ``` json
    {
      "sub": "customer",
      "name": "finance-service",
      "iat": {{$timestamp}}
    }
    ```
* Request header prefix: Bearer
* JWT headers: un json vacío ```{}```

## Ejecución

Hay dos opciones para poder lanzar el proyecto de forma local:
1. Usando el comando mvn, para lo cual hay que tener instalado Maven así como el SDK de Java 21
   en el computador, y también se deben configurar las variables de entorno. Después de tener estas
   configuraciones, simplemente se debe abrir un terminal, posicionarse en la raíz del proyecto
   y escribir los siguientes comandos
    ``` shell
    mvn clean install
    mvn spring-boot:run
   ```
2. Ejecutando el proyecto desde IntelliJ Idea, para lo cual lo único necesario es configurar la
   versión de Java 21 desde la configuración *File → Project Structure → SDK*, y luego seleccionar
   la clase main desde la opción de *Aplication* en la configuración *run/debug configuration*
   o, en su defecto, correr los comandos *Maven* desde el panel derecho. Los comandos son
   ```clean```, ```compile``` y ```spring-boot```

*Por defecto se ejecuta en el puerto 8081, por lo que se debe tener en cuenta el no tener
ninguna otra aplicación ejecutándose en este puerto.*

## Definición funcional

### Objeto de negocio

Se realizó un completo análisis del objeto de negocio y el resultado se plasma en el siguiente Json:
```json
{
  "customerId": "int",
  "fullName": "string",
  "income": "float",
  "city": "string",
  "accessPassword": "string",
  "countryCode": "string",
  "age": "int"
}
```
```customerId```: Hace referencia al identificador único de cada cliente.  
```fullName```: El nombre del cliente.  
```income```: Los ingresos mensuales del cliente.  
```city```: La ciudad de residencia del cliente.
```accessPassword```: Contraseña de acceso del cliente. Esta contraseña pasa por un proceso de *Hash*
antes de ser almacenada en base de datos. La función matemática de Hash empleada es *SHA256*.
```countryCode```: Código único del país de residencia. Este código se utiliza para filtrar por país.
```age```: La edad del cliente.

### Ejemplo
```json
{
  "fullName": "Gerardo Palacios",
  "income": 3200000.0,
  "city": "Medellín",
  "accessPassword": "Password-seguro1",
  "countryCode": "CO",
  "age": 25
}
```

### Dominio de datos

### Contrato Openapi 3.0.1

La firma puede ser encontrada en **[esta página](https://fcordonezo.github.io/AP202403_customer/)**
``` yaml
openapi: 3.0.1
info:
  title: Cliente
  version: 1.0.0
servers:
- url: http://localhost:8081/api/development/v1/finance-service/customers
  description: Generated server url
paths:
  /{customerId}:
    get:
      tags:
      - customer-controller
      summary: Obtener cliente por ID
      operationId: getById
      parameters:
      - name: customerId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CustomerResponseDto'
      security:
      - BearerAuthentication: []
    put:
      tags:
      - customer-controller
      summary: Actualizar un cliente
      operationId: put
      parameters:
      - name: customerId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CustomerRequestDto'
        required: true
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CustomerResponseDto'
      security:
      - BearerAuthentication: []
    delete:
      tags:
      - customer-controller
      summary: Eliminar un cliente por ID
      operationId: delete
      parameters:
      - name: customerId
        in: path
        required: true
        schema:
          type: integer
          format: int64
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: object
      security:
      - BearerAuthentication: []
  /:
    get:
      tags:
      - customer-controller
      summary: Obtener todos los clientes
      operationId: getAll_1
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/CustomerResponseDto'
      security:
      - BearerAuthentication: []
    post:
      tags:
      - customer-controller
      summary: Agregar un cliente
      operationId: post_1
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CustomerRequestDto'
        required: true
      responses:
        "201":
          description: Created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CustomerResponseDto'
      security:
      - BearerAuthentication: []
components:
  schemas:
    CustomerRequestDto:
      type: object
      properties:
        fullName:
          type: string
        accessPassword:
          type: string
        income:
          type: number
          format: float
        city:
          type: string
        countryCode:
          type: string
        age:
          type: integer
          format: int32
    CustomerResponseDto:
      type: object
      properties:
        customerId:
          type: integer
          format: int64
        fullName:
          type: string
        income:
          type: number
          format: float
        city:
          type: string
        countryCode:
          type: string
        age:
          type: integer
          format: int32
  securitySchemes:
    BearerAuthentication:
      type: http
      scheme: bearer
      bearerFormat: JWT
```

## Documentación de referencia

Puede encontrar el repositorio de documentación en el [siguiente enlace](https://github.com/fcordonezo/AP202403_documentation)

### Documentación oficial

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
* [Spring Security](https://spring.io/projects/spring-security)

### Guías

* [Construyendo un servicio RESTful](https://spring.io/guides/gs/rest-service/)
* [Construyendo servicios REST con Spring](https://spring.io/guides/tutorials/rest/)
* [Intro to JWT](https://jwt.io/introduction)

