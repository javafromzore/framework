package course.linkflower.link.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
public class SystemApp {
    public static void main(String[] args) {
        SpringApplication.run(SystemApp.class, args);
    }
}
