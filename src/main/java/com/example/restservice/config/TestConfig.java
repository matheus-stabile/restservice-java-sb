package com.example.restservice.config;

import com.example.restservice.entities.Client;
import com.example.restservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = (sdf.parse("01/05/1987"));

        Client c1 = new Client(
                "Matheus",
                "matheus@gmail.com",
                "34005923828",
                new java.sql.Date(birthDate.getTime()));

        Client c2 = new Client(
                "Matheus",
                "matheus@gmail.com",
                "34005923828",
                new java.sql.Date(birthDate.getTime()));


                clientRepository.save(c1);

        Date teste = new java.sql.Date(birthDate.getTime());
        System.out.println(teste);

    }
}
