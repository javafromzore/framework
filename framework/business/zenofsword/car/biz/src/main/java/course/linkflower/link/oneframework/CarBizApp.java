package course.linkflower.link.oneframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarBizApp {
    public static void main(String[] args) {
        SpringApplication.run(CarBizApp.class, args);
    }
}
