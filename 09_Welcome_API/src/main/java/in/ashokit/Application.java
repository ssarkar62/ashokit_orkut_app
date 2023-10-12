package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//it is register our app as a client for discovery server.
@EnableDiscoveryClient
@SpringBootApplication 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
