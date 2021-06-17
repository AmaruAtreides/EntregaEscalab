package micro.composer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ComposerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposerApplication.class, args);
    }

}
