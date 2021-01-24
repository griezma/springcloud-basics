package griezma.scbasic.helloservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloServiceApplicationTests {
    @Autowired
    TestRestTemplate restClient;

    @Test
    void contextLoads() {
    }

    @Test
    void saysHello() {
        String repsonse = restClient.getForObject("/api/v1/hello/mani", String.class);
        assertEquals("hi there mani", repsonse);
    }

}
