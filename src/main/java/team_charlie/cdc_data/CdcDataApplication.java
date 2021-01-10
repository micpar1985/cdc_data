package team_charlie.cdc_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CdcDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcDataApplication.class, args);
	}

}
