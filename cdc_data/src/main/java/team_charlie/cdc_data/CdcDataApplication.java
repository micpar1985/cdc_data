package team_charlie.cdc_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CdcDataApplication {

	private String name;

	public static void main(String[] args) {
		SpringApplication.run(CdcDataApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue "Mike") String name) {
		this.name = name;
		return String.format("Hello %s!", name);
	}
}
