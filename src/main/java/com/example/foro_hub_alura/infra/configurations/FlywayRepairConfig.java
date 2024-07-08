package com.example.foro_hub_alura.infra.configurations;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayRepairConfig {
  @Autowired
        private Flyway flyway;

        @Bean
        public CommandLineRunner repairFlyway() {
            return args -> {
                flyway.repair();
            };
        }
}
