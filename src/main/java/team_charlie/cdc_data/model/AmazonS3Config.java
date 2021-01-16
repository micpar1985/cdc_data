package team_charlie.cdc_data.model;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AmazonS3Config implements EnvironmentAware
{
    private static String awsKeyId;
    private static String awsKeySecret;
    private static String awsS3Region;
    private static String awsS3Bucket;
    private static String awsS3Object;

    @Override
    public void setEnvironment(Environment environment) {
        this.awsKeyId = environment.getProperty("aws.accesskeyid");
        this.awsKeySecret = environment.getProperty("aws.accesskeysecret");
        this.awsS3Region = environment.getProperty("aws.s3region");
        this.awsS3Bucket = environment.getProperty("aws.s3bucket");
        this.awsS3Object = environment.getProperty("aws.s3object");
    }

    public static String getAwsKeyId() {
        return awsKeyId;
    }

    public static String getAwsKeySecret() {
        return awsKeySecret;
    }

    public static String getAwsS3Region() {
        return awsS3Region;
    }

    public static String getAwsS3Bucket() {
        return awsS3Bucket;
    }

    public static String getAwsS3Object() {
        return awsS3Object;
    }
}

