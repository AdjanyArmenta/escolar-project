package edu.uady.academia;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Log4j2
@Configuration
@PropertySource(value="application.properties")
public class AcademiaApplication implements CommandLineRunner {

    @Autowired
    private Environment env;
    
    public static void main(String[] args) {
        SpringApplication.run(AcademiaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(env.getProperty("URL_COA"));
    }
}
