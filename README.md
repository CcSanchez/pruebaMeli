# Challegue Mercado Libre

Challegue tecnico mercado libre,el fin del challegue es codificar una solucion en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos
de desarrollo y pruebas._

### Instalación 🔧

```
mvn clean
```

```
mvn install
```

## End Points

* /stats : Peticion GET, obteniene las estadisticas de cuantos adns corresponden a mutantes y cuantos a humanos
```

```

* /mutants : Peticion POST, con base al adn ingresado determina si es mutante o no
```
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}
```


## Swagger

* [Local](http://localhost:5000/swagger-ui.html#/) - link a swagger al desplegarlo
  localmente(http://localhost:5000/swagger-ui.html#)


* [AWS](http://prueba-env.eba-5sa4v936.us-east-2.elasticbeanstalk.com/swagger-ui.html#/) - link a swagger en ASW (http://prueba-env.eba-5sa4v936.us-east-2.elasticbeanstalk.com/swagger-ui.html#/)

## Construido con 🛠️

* [Git](http://www.dropwizard.io/1.0.2/docs/) - Manejo de versiones
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [SpringBoot](https://rometools.github.io/rome/) - Framework usado
* [Jacoco](https://rometools.github.io/rome/) - Dependencia usada para evaluar el coverage de unit test
* [JMeter](https://jmeter.apache.org/) - Ide usado para generar pruebas de carga

## Versionado 📌

Version 1.0.0 Creacion proyecto inicial que cumple con los requerimientos

## Autor ✒️

* **Cristian Camilo Sanchez Rozo** - *Challegue tecnico* - [csanchez](https://github.com/CcSanchez/pruebaMeli)

---