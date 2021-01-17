package team_charlie.cdc_data;

//import team_charlie.cdc_data.model.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Base64;

import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
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

		getData();

	}

	//@GetMapping("/getcdcdata")
	public static String getData() {

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

		/*AWSCredentials credentials = new BasicAWSCredentials(
				getAwsKeyId(),
				getAwsKeySecret()
		);*/

		AWSCredentialsProvider credentialsProvider = InstanceProfileCredentialsProvider.getInstance();

		AmazonS3 s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new DefaultAWSCredentialsProviderChain())
				.withRegion("us-west-2")
				.build();

		s3client.toString();

		String acctOwner = s3client.getS3AccountOwner().getDisplayName();

		/*s3client.putObject(
				AmazonS3Config.getAwsS3Bucket(),
				AmazonS3Config.getAwsS3Object(),
				new File(filepath)
		);*/

		return ("CDC data is now refreshed!");
	}
}
