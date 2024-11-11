package org.example.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "alarm")
public record AlarmServerProperty(
    String apiURL
) {
}
