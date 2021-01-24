package griezma.scbasic.helloservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(HelloConfig.class)
public class HelloServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }
}

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
class HelloApi {
    private final HelloConfig config;

    @GetMapping("/hello/{caller}")
    String getHello(@PathVariable String caller) {
        log.debug("hello called from {}", caller);
        return config.getGreeting() + " " + caller;
    }
}

@ConfigurationProperties("hello")
@Getter @Setter
class HelloConfig {
    private String greeting = "hello";
}
