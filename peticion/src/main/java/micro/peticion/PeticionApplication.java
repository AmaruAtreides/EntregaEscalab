package micro.peticion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PeticionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeticionApplication.class, args);
    }

}
