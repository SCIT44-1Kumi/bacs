package net.softsociety.bacs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "net.softsociety.bacs")
@EnableJpaAuditing
public class BacsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BacsApplication.class, args);
    }

}
