package org.example.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "s3")
public record S3Property(
    String accessKey,
    String secretKey,
    String region,
    String bucket
) {

}
