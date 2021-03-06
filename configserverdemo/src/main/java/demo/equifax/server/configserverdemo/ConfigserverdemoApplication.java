package demo.equifax.server.configserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableEurekaClient
@EnableConfigServer
public class ConfigserverdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigserverdemoApplication.class, args);
    }

}
