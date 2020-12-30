package com.example.restservice.config;

import com.example.restservice.entities.Client;
import com.example.restservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
