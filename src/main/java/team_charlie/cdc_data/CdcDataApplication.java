package team_charlie.cdc_data;

import team_charlie.cdc_data.model.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import static team_charlie.cdc_data.model.AmazonS3Config.*;

@SpringBootApplication
@RestController
public class CdcDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcDataApplication.class, args);
	}

	/*@GetMapping("/getcdcdata")
	public String getData() {

		final String uri = "https://data.cdc.gov/resource/vbim-akqf.json";
		RestTemplate restTemplate = new RestTemplate();
		String urlresult = restTemplate.getForObject(uri, String.class);
		String filepath = "No path assigned";

		try {
			File tmpFile = File.createTempFile("cdcdata", ".json");
			FileWriter writer = new FileWriter(tmpFile);
			writer.write(urlresult);
			writer.close();

			filepath = tmpFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}

		AWSCredentials credentials = new BasicAWSCredentials(
				getAwsKeyId(),
				getAwsKeySecret()
		);

		AmazonS3 s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(getAwsS3Region())
				.build();

		s3client.putObject(
				AmazonS3Config.getAwsS3Bucket(),
				AmazonS3Config.getAwsS3Object(),
				new File(filepath)
		);

		return ("CDC data is now refreshed!");
	}*/
}
