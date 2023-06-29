#!/bin/bash

echo "Deteniendo y eliminando los contenedores y volúmenes..."
docker-compose down -v

echo "Ejecutando el contenedor de MySQL..."
# Verificar si el contenedor ya existe
if docker inspect openmarket_app_db_container >/dev/null 2>&1; then
  echo "El contenedor openmarket_app_db_container ya está creado. Saltando la ejecución de 'docker run'."
else
  echo "Ejecutando el contenedor de MySQL..."
  docker run --rm --name openmarket_app_db_container -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=openmarket_app_db -d -p 3307:3306 mysql
fi

echo "Compilando y empaquetando el proyecto consumerproduct..."
mvn clean package -f consumerproduct/pom.xml

echo "Compilando y empaquetando el proyecto consumercategory..."
mvn clean package -f consumercategory/pom.xml

echo "Compilando y empaquetando el proyecto producerproduct..."
mvn clean package -f producerproduct/pom.xml

echo "Compilando y empaquetando el proyecto producercategory..."
mvn clean package -f producercategory/pom.xml

echo "Compilando y empaquetando el proyecto api..."
mvn clean package -f api/pom.xml

echo "Creando y ejecutando los servicios definidos en docker-compose.yml..."
docker-compose up --build -d
