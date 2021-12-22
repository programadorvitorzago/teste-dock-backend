package com.example.DockApi.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.DockApi.Repositorio.RepositorioDockApi;
import com.example.DockApi.Repositorio.Objeto.Terminal;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RepositorioDockApi repository) {

    return args -> {
    	Terminal terminal;
    	
    	terminal = new Terminal();
    	terminal.setLogic(111);
    	terminal.setSerial("123456");
    	terminal.setModel("MD-12Z8");
    	log.info("Carregando " + repository.save(terminal));
    	
    	terminal = new Terminal();
    	terminal.setLogic(222);
    	terminal.setSerial("777888999");
    	terminal.setModel("YOGA-15Z");
    	terminal.setMxr(12);
    	terminal.setMxf(8);
    	terminal.setPVERFM("1985");
    	log.info("Carregando " + repository.save(terminal));

    };
  }
}