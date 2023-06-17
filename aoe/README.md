# Packages Diagrams

## Producer Package Diagram

<p align="center">
    <img src="diagrams/packages_diagrams/diagramas-svg/paqueteProducer.svg"/>
</p>



## ConsumerDb Package Diagram


<p align="center">
    <img src="diagrams/packages_diagrams/diagramas-svg/paqueteConsumerdb-v2.svg"/>
</p>

## ConsumerCsv Package Diagram

<p align="center">
    <img src="diagrams/packages_diagrams/diagramas-svg/paqueteConsumercsv.svg"/>
</p>

## Componets Diagram 

This System consists of the following components.

<p align="center">
    <img src="diagrams/sequence_componets_diagrams/diagramas-svg/Componentes.drawio.svg"/>
</p>

The overall structural approach employed is Microservices, while additionally, the event-driven architectural design was implemented to manage the Publisher/Subscriber model.

## Producer sequence Diagram

this component works as a CRUD server for OpenMarket. It also publishes 
events in a RabbitMQ Fanout.

<p align="center">
    <img src="diagrams/sequence_componets_diagrams/diagramas-svg/Diagrama%20de%20Secuencia-Publisher.drawio.svg"/>
</p>

## ConsumerDb sequence Diagram

This component receives the message from RabbitMQ that contains the product object 
with the realized action and stores it in the database.

<p align="center">
    <img src="diagrams/sequence_componets_diagrams/diagramas-svg/DiagramadeSecuenciaConsumer.svg"/>
</p>

## ConsumerCsv sequence Diagram

 This component receives the message from RabbitMQ that contains a petition, which will then be stored in a CSV file.

<p align="center">
    <img src="diagrams/sequence_componets_diagrams/diagramas-svg/DiagramadeSecuenciaConsumercsv.svg"/>
</p>