package in.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetRestController {
	
	@Autowired
	private WelcomeApiClient apiClient;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		
		String greetResponse="Good Morning";
		String welcomeResponse = apiClient.invokeWelcomeApi();
	
	return greetResponse+" , "+welcomeResponse;
	}
}
