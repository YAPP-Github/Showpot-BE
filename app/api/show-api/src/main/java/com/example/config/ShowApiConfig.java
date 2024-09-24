package com.example.config;

import com.example.artist.sub.config.SubscriptionMessageConfig;
import org.example.config.ShowDomainConfig;
import org.example.config.UserDomainConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShowDomainConfig.class, UserDomainConfig.class, SubscriptionMessageConfig.class})
@ComponentScan(basePackages = "com.example")
public class ShowApiConfig {

}
