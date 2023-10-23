# Prueba técnica para AMS creada por Fernando Garcia Doval

La prueba consiste en crear una aplicación web que implemente un servicio REST que sirva como intermediario con otro proveedor

Los detalles y el enunciado de la prueba se pueden encontrar en https://github.com/dalogax/backendDevTest

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.1.5

## Forma de despliegue

1. En *devtest/compose* se encuentra el docker-compose.yml que despliega toda la aplicacion, basta con ejecutar *docker compose up* en dicha ruta
2. Para no depender de Postman o cualquier otro cliente REST he utilizado la dependencia *springdoc-openapi-starter-webmvc-ui* que te levanta en *http://localhost:5000/ams/swagger-ui/index.html* una interfaz gráfica para usar ambos endpoints
3. Si por el contrario se prefiere usar un cliente REST se puede atacar a http://localhost:5000/ams/product/{productId}/similar
4. Para parar la aplicación simplemente parar el docker compose

## Forma de testing

1. Para esta prueba no he realizado tests dentro del proyecto, he entendido que no forma parte de la finalidad de la prueba y ya se dispone de un metodo de testeo con informe en grafana
2. Ejecutar desde la carpeta *devtest/compose* docker-compose run --rm k6 run scripts/test.js 

## Explicación de las decisiones tomadas y aclaraciones

- Se ha usado el generador de servidor y cliente de https://editor.swagger.io/ para las clases del modelo y para la API usando los dos contratos swagger de la prueba
- Se ha cacheado el servicio que llama al proveedor externo para optimizar los tiempos de espera, he supuesto que la información de los productos no va a cambiar muy frecuentemente
