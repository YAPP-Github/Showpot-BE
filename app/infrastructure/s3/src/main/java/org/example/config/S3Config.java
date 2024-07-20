package org.example.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.example.property.S3Property;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(S3Property.class)
@ComponentScan(basePackages = {"org.example"})
@RequiredArgsConstructor
public class S3Config {

    private final S3Property s3Property;

    @Bean
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder.standard()
            .withRegion(s3Property.region())
            .withCredentials(new AWSStaticCredentialsProvider(awsBasicCredentials()))
            .build();
    }

    private BasicAWSCredentials awsBasicCredentials() {
        return new BasicAWSCredentials(
            s3Property.credentials().accessKey(),
            s3Property.credentials().secretKey()
        );
    }

    public String getBucketName() {
        return s3Property.s3().bucket();
    }

}
