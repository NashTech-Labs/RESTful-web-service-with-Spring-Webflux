
## README
# Create a WebFlux application with Spring Boot
* The Spring Boot 2.x targets the latest Spring technology stack, including Spring 5, Spring Security 5, Spring Session 2, etc.

* Spring Boot added a new starter spring-boot-starter-webflux for starting a WebFlux application.

Generate project skeleton
Follow the following steps to prepare the project skeleton using Spring initializr.

> Open your browser and navigate to http://start.spring.io.
>
* Download the archive and extract files into your disc, import the source codes into your IDEs.

Open the pom.xml, you will see the spring-boot-starter-webflux is added into dependencies.
````
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
````
### Compare to the former  version,

>>No need explicit WebConfig, Spring Boot configures it automatically.
The former bootstraping class or AppInitializer is no use now, the Spring Boot built-in @SpringBootApplication annotated class hands over the applicationContext lifecyle and application bootstrap.

```
@SpringBootApplication
public class ResTfulWebServiceWithSpringWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulWebServiceWithSpringWebfluxApplication.class, args);
	}
}
```
* By default, Spring Boot will use Reactor Netty as runtime to run a WebFlux application. No need extra configuration for it.

* To start the application in your terminal, run the following command in the project root folder.
````
mvn spring-boot:run
````
Alternatively, to start Spring Boot applications in your IDEs, run it just like running a general-purpose Java application.

