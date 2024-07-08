package org.example.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "admin")
public record UserAdminProperty(
    String password
) {

}
