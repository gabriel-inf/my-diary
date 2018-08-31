package com.messages.diario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class Application implements CommandLineRunner {

    @Autowired
    private MessageRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        repository.save(new Message("Gabe", "Uhuuul"));
        repository.save(new Message("Jonny", "My name is not Jonny"));
        repository.save(new Message("Willy", "Miau"));
        repository.save(new Message("Gabe", "This is the last message I sent yesteday =O"));
    }

}