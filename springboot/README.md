# How to convert Maven Project on Spring Boot API

## Introduction:

In the world of Java development, Spring Boot has gained immense popularity due to its simplicity and ease of use. If you have an existing Maven project and want to leverage the power of Spring Boot to build an API, you've come to the right place. In this blog post, we'll guide you through the process of converting your Maven project into a Spring Boot API step by step. So let's dive in!

## What’s an API?

Before we delve into the conversion process, let's start by understanding what an API is. API stands for Application Programming Interface. It acts as a bridge between different software applications, allowing them to communicate and interact with each other. APIs define a set of rules and protocols that govern how these interactions occur.

## What’s SpringBoot?

Spring Boot is a framework built on top of the popular Spring framework. It aims to simplify the process of creating production-ready Spring applications. Spring Boot provides out-of-the-box solutions for configuration, dependency management, and auto-configuration, allowing developers to focus more on writing business logic rather than boilerplate code.

## How SpringBoot works?

Spring Boot follows a convention-over-configuration approach, which means it provides sensible defaults and configurations, reducing the need for explicit configuration files. It uses embedded servers, such as Tomcat or Jetty, which makes it easy to deploy and run Spring Boot applications without the need for external containers.

## What dependencies are required?

To convert your Maven project into a Spring Boot API, you'll need to add certain dependencies to your project's pom.xml file. These dependencies include the Spring Boot starter dependencies, which provide a curated set of libraries to get you started quickly. Additionally, you may need to include dependencies based on the specific functionality you require for your API.

## How to run the project

Once you have converted your Maven project into a Spring Boot API and added the necessary dependencies, running the project is a breeze. Spring Boot provides a simple and intuitive way to run your application. You can either use an IDE such as IntelliJ or Eclipse, or you can run the application from the command line using the Maven wrapper or the java -jar command.

## Conclusion:

Converting a Maven project into a Spring Boot API is a straightforward process that can greatly enhance your development experience. Spring Boot's simplicity and robustness make it an excellent choice for building APIs. By following the steps outlined in this blog post, you'll be well on your way to transforming your Maven project into a powerful and efficient Spring Boot API. So go ahead, give it a try, and unlock the potential of Spring Boot for your projects!

## Getting Started

### Inicializar CodeBase

1. Inicializar la base de código del proyecto
   https://start.spring.io/

2. Escriba los siguientes datos (puede mantener los mismos del proyecto en maven)
   groupId: com.unicauca
   artifactId: openmarket
   name: openmarket
   description: OpenMarket project for Spring Boot.
   Package name: com.unicauca.openmarket

Seleccionar una versión estable: 2.7.11

3. Buscar y seleccionar las siguientes dependencias:

- **Spring Web:** Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
- **H2 Database:**Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.
- **Spring Data JPA:** Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
- **Spring Boot DevTools:** Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
- **Lombok:** Java annotation library which helps to reduce boilerplate code.
- **Validation:** Bean Validation with Hibernate validator.

4. Descargar el .zip y descomprimir
5. (Opcional recomendado): inicializar el repositorio git

### Arquitectura del proyecto

Para la arquitectura del proyecto se sigue manteniendo el estilo por capas: access, domain, presentation, utils.

Crea la siguiente estructura de paquetes dentro de java/com/unicauca/openmarket/:

- access
- domain
  - entity
  - service
- presentation
  - rest
- utils

#### Entidades

1. Crear los modelos necesarios en domain/model (sin constructor y sin getters/setters):
   1. Product
2. Para cada clase creada anteriormente agregar las siguientes etiquetas encima de la declaración de la clase:
   1. @Entity (indica que es una entidad en la base de datos)
   2. @Table(name = “class name”) si la clase es Product, el valor sería “product” (indica el nombre que va a tener la tabla en la base de datos)
   3. @Data (esta anotación agrega el constructor por defecto, los getters y setters)
3. Para cada atributo de cada clase agregar las validaciones correspondientes:
   1. Para el id: @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
   2. Para los demás atributos consulte las validaciones posibles: https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints

#### Access

Cree las interfaces requeridas para los repositorios de cada Entidad en access/.

**Ejemplo para Products**

```java
public interface IProductRepository extends CrudRepository<Product, Long>{

}
```

#### Service

Cree las interfaces requeridas para los servicios de cada Entidad en domain/service/.

**Ejemplo para Products**

```java
public interface IProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product findById(long id);
}
```

**Nota:** Puede agregar los métodos que quiera en el servicio

Ahora cree la implementación de cada servicio:

**Ejemplo para IProductService**

```java
@Service // Indicates this class is a service
public class ProductServiceImpl implements IProductService{

    @Autowired // Injects an instance of IProductRepository into this service without the need of a constructor
    private IProductRepository repository;

    @Override
    @Transactional(readOnly = false) // Read only = false to indicate this method is going to modify the database
    /** Using the @Transactional annotation provides essential benefits like transactional consistency, atomicity, data integrity, simplified management, increased productivity, flexibility, and seamless integration with other Spring features. It helps ensure reliable and robust database operations in your Spring Boot application.*/
    public Product create(Product product) {
        // TODO: adding some business logic here
        return this.repository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(long id) {
        return this.repository.findById(id).orElse(null);
    }

    ...
}
```

#### Presentation

Crear un Controlador Rest para cada servicio

**Ejemplo para Products**

```java
@RestController
@RequestMapping("products")
public class ProductsController {
    ...
    // Inyectar el Servicio
	@Autowired
	private IProductService productService;

    // Hacer el mapeo de los métodos HTTP a los métodos del servicio
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> findAll() {
        System.out.println("Entra al findAll");
		return (List<Product>) productService.findAll();
	}

    ...
}
```

### Utilizar Postman como cliente HTTP
