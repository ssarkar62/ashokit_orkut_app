package in.ashokit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//IMPLEMENTATION IS PROVIDED AT THE RUNTIME.
//FEIGN CLIENT is used to make interservice communication.
//we can access one api from another api using api name
//provided in service registry.
//this interface is not a normal interface ,
//10 oct 23 , 1 h:4 min
//now restTemplate or webClient is not required ,feignclient is sufficient
//simply call the method
//when we go with restTemplate or webclient , we need to hardcode the url
//FeignClient internally use loadbalancer in client side.
//load is distributed by feign client.
@FeignClient(name = "WELCOME-API")
public interface WelcomeApiClient {

	@GetMapping("/welcome")
	public String invokeWelcomeApi();
}
