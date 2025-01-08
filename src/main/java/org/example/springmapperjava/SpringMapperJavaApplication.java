package org.example.springmapperjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMapperJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMapperJavaApplication.class, args);
    }
    @Bean
        public CommandLineRunner commandLineRunner(PersonService service) {
            return args -> {
                service.populateDB();
                System.out.println("--------------------------------------");
                service.getAllPersonDTO().forEach(System.out::println);
                System.out.println("--------------------------------------");
                service.getAllPersonDTO2().forEach(System.out::println);
                System.out.println("--------------------------------------");
            };
        }
}
