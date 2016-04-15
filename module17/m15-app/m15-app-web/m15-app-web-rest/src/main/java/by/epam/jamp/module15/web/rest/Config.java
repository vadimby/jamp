package by.epam.jamp.module15.web.rest;

import org.springframework.context.annotation.Bean;

import by.epam.jamp.module15.service.person.PersonService;
import by.epam.jamp.module15.service.person.PersonServiceStaticImpl;

//@Configuration
//@EnableWebMvc
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "by.epam.jamp.module15")
public class Config {
  
  @Bean
  public PersonService getPersonService() {
    return new PersonServiceStaticImpl();
  }
  
}
