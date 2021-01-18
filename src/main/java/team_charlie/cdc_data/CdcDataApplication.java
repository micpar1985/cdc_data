package team_charlie.cdc_data;

//import team_charlie.cdc_data.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@RestController
public class CdcDataApplication {

    private static String filepath = "No path assigned";

    public static void main(String[] args) {
        SpringApplication.run(CdcDataApplication.class, args);
        System.out.println(getData());
    }

    //@GetMapping("/getcdcdata")
    public static String getData() {

        final String uri = "https://data.cdc.gov/resource/vbim-akqf.json";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String urlresult = restTemplate.getForObject(uri, String.class);

            File tmpFile = File.createTempFile("cdcdata", ".json");
            FileWriter writer = new FileWriter(tmpFile);
            writer.write(urlresult);
            writer.close();

            filepath = tmpFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion("us-west-2")
                .build();

        s3client.putObject("my-cdc-bucket",
                "cdc-data-file",
                new File(filepath));

        return ("CDC data is now refreshed!");
    }
}
