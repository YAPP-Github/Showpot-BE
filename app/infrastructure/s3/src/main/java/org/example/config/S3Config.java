package org.example.config;

import lombok.RequiredArgsConstructor;
import org.example.property.S3Property;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@RequiredArgsConstructor
public class S3Config {

    private final S3Property s3Property;

    @Bean(name = "s3Client")
    public S3Client s3Client() {
        return S3Client.builder()
            .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials()))
            .region(Region.of(s3Property.region()))
            .build();
    }

    private AwsBasicCredentials awsBasicCredentials() {
        return AwsBasicCredentials.create(
            s3Property.credentials().accessKey(),
            s3Property.credentials().secretKey()
        );
    }

    public String getBucketName() {
        return s3Property.s3().bucket();
    }

}
