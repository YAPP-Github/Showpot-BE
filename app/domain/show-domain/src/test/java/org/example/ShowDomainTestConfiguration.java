package org.example;

import org.example.config.ShowDomainConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {ShowDomainConfig.class})
public class ShowDomainTestConfiguration {

}
