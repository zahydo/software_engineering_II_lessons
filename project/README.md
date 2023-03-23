# Proyecto: “Open Market” 

## Descripción del Problema

La empresa Colombo-Argentina Digital Asociados SA, está interesada en lanzar al mercado una plataforma tecnológica para hacer mercadeo por internet y ser competidores de plataformas conocidas como Mercado Libre. Esta empresa requiere desarrollar una aplicación web que permita a sus usuarios comprar, vender y distribuir productos en línea por medio de una aplicación web de forma segura, rápida y fácil de usar.  A continuación se detallan los requisitos funcionales y no funcionales de esta aplicación. 

## Funcionalidad obligatoria

- Loguear un usuario con uno de los roles del sistema (Visitante: sin registro, Registrado: Comprador o Vendedor).
- La creación de usuarios se puede hacer por script de BD. Se podrá utilizar productos de gestión de datos tipo Liquibase de forma que la DB evolucione al mismo tiempo que el schema sea versionado y se pueda inicializar con datos predefinidos.
- Los datos de negocio (por ejemplo las comisiones) deben estar adecuadamente abstraídos y quemados en el mismo sistema. (para el MVP no es necesario gestionar esto en una tabla de BD)
- Rol usuario registrado Datos personales
  - Datos del usuario que deben considerarse en el script:
    - username, contraseña, nombre, apellido, email, teléfono, rol, fecha de nacimiento, puntuación.
- Rol usuario: Visitante
  - Listar productos.
  - Búsqueda de productos. Las búsquedas son por palabras (la búsqueda se realizará usando el título y descripción)
- Rol vendedor: dar de alta, baja y modificación de productos (CRUD) 
  - Al agregar productos ofrecidos:
    - Debe tener al menos nombre, descripción, precio, categoría (tabla aparte) y ubicación, usando la latitud y longitud.
  - Modificar stock de productos ofrecidos 
  - Dar de baja productos ofrecidos.
  - Suspender publicación.
- Rol usuario Comprador: Realizar Compra
  - Comprar productos. Las compras se administran  directamente sin la necesidad de un carrito de compras. 
  - Al realizar la compra, el comprador se transfiere a un sistema de pagos externo (puede ser simulado) quién le confirma el pago realizado. Si es exitoso se le confirma a las partes y se debe actualizar el stock.
  - El comprador al recibir el producto confirma el recibido (y puntúa de 1  a 5 el comprador) y si está correcto, a través del sistema de pagos se le transfiere el valor de la venta menos la comisión al vendedor.


## Consideraciones de la arquitectura de software

La aplicación a desarrollar es una sola y permitirá a los vendedores publicar productos, a los compradores buscarlos y comprarlos. Esto implica que se debe plantear una arquitectura de software que soporte la escalabilidad (a medida que se sumen usuarios compradores y vendedores) y la seguridad de los datos (el sistema, a pesar que es uno sólo, debe aislar la información de usuario, importante definir mecanismo de autenticación y autorización seguros). 

## Trabajo en equipo

Se debe trabajar en grupos de cuatro o máximo cinco personas (En caso de que sean cinco personas debe agregarse la funcionalidad de un carrito de compras). Es importante que cada equipo trabaje de forma colaborativa, donde haya buenas relaciones entre todos sus integrantes. El equipo debe buscar herramientas que favorezcan la comunicación durante el proyecto y la coordinación de tareas.

## Metodología

El equipo deberá trabajar con el marco de gestión de Scrum, en tres sprints, definiendo los roles Scrum Master, Product Owner y Equipo de Trabajo. Debe hacer seguimiento periódico al trabajo (cada sesión) y se deben seguir las ceremonias de planificación, trabajo diario, revisión y retrospectiva (debe haber evidencia). Para el seguimiento se debe utilizar una herramienta de apoyo como Trello o Jira. Respecto a las prácticas de desarrollo se deben usar las prácticas de XP. Para el trabajo en equipo la propiedad colectiva de código 

## Entregables

Para los tres cortes se debe entregar:

- Repositorio de Código
- Especificación de requisitos NO funcionales que se resuelven con este proyecto.
- ¿Qué tecnologías ayudan a cumplir con los requisitos no funcionales especificados.
- Documentación de la arquitectura ya sea con el modelo C4 o UML.
- Resumen de Decisiones de Diseño
- Imagen de docker publicada en un Registry (opcional)


