package org.example;

import org.example.config.UserDomainConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {UserDomainConfig.class})
public class UserDomainTestConfiguration {

}
