package com.paloit.zombieapocalypse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.paloit.zombieapocalypse"})
public class ZombieApocalypseApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZombieApocalypseApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().build();
  }

}
