## Diagramas de componentes

This System consists of the following components.

<p align="center">
    <img src="./diagramas-svg/Componentes.drawio.svg"/>
</p>

The overall structural approach employed is Microservices, while additionally, the event-driven architectural design was implemented to manage the Publisher/Subscriber model.

## Diagrama de secuencia Producer

this component works as a CRUD server for OpenMarket. It also publishes 
events in a RabbitMQ Fanout.

<p align="center">
    <img src="./diagramas-svg/Diagrama%20de%20Secuencia-Publisher.drawio.svg"/>
</p>

## Diagrama de secuencia ConsumerDb

This component receives the message from RabbitMQ that contains the product object 
with the realized action and stores it in the database.

<p align="center">
    <img src="./diagramas-svg/DiagramadeSecuenciaConsumer.svg"/>
</p>

## Diagrama de secuencia ConsumerCsv

 This component receives the message from RabbitMQ that contains a petition, which will then be stored in a CSV file.

<p align="center">
    <img src="./diagramas-svg/DiagramadeSecuenciaConsumercsv.svg"/>
</p>


