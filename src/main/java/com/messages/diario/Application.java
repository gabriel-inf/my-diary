package com.messages.diario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
    }


    private static final Logger log = LoggerFactory.getLogger(Application.class);




    

    // @Bean
    // public CommandLineRunner demo(MessageRepository repository){
    //     return (args) -> {
    //         repository.save(new Message("Gabe", "Uhuuul"));
    //         repository.save(new Message("Jonny", "My name is not Jonny"));
    //         repository.save(new Message("Willy", "Miau"));
    //         log.info("Mensagens listadas:");

    //         for (Message mensagem : repository.findAll()){
    //             log.info(mensagem.toString());
    //         }

    //     };
    // }

}