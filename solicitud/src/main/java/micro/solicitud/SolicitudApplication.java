package micro.solicitud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class SolicitudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolicitudApplication.class, args);
    }

}
