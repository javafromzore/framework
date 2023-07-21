package course.linkflower.link.oneframeworkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HouseBizApp {
    public static void main(String[] args) {
        SpringApplication.run(HouseBizApp.class, args);
    }
}
