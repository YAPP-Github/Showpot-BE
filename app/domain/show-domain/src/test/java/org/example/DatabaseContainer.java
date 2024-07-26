package org.example;


import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import java.util.function.Consumer;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class DatabaseContainer {

    protected static final PostgreSQLContainer<?> postgresql;

    static {
        postgresql = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"))
            .withCreateContainerCmdModifier(bingPort())
            .withDatabaseName("test-database")
            .withUsername("test-user")
            .withPassword("test-password");

        postgresql.start();
    }

    private static Consumer<CreateContainerCmd> bingPort() {
        return cmd -> cmd.withHostConfig(new HostConfig().withPortBindings(
            new PortBinding(Ports.Binding.bindPort(36915), new ExposedPort(5432))
        ));
    }

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresql::getJdbcUrl);
        registry.add("spring.datasource.username", postgresql::getUsername);
        registry.add("spring.datasource.password", postgresql::getPassword);
    }

}
