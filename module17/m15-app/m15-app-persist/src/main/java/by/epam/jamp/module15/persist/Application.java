package by.epam.jamp.module15.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import by.epam.jamp.module15.persist.model.PersonTable;
import by.epam.jamp.module15.persist.repositories.PersonRepository;

@SpringBootApplication
public class Application {
  
  private static final Logger log = LoggerFactory.getLogger(Application.class);
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
  
  @Bean
  public CommandLineRunner demo(PersonRepository repository) {
    return (args) -> {
      // save a couple of customers
      repository.save(getPersonTable("Jack", "Bauer", "Jack.Bauer@gmail.com"));
      repository.save(getPersonTable("Chloe", "O'Brian", "Chloe.O'Brian@gmail.com"));
      repository.save(getPersonTable("Kim", "Bauer", "Kim.Bauer@gmail.com"));
      repository.save(getPersonTable("David", "Palmer", "David.Palmer@gmail.com"));
      repository.save(getPersonTable("Michelle", "Dessler", "Michelle.Dessler@gmail.com"));
      
      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (PersonTable customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");
      
      // fetch an individual customer by ID
      PersonTable customer = repository.findOne(1L);
      log.info("Customer found with findOne(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");
      
      // fetch customers by last name
      log.info("Customer found with findByEmail('Chloe.O'Brian@gmail.com'):");
      log.info("--------------------------------------------");
      for (PersonTable bauer : repository.findByEmail("Chloe.O'Brian@gmail.com")) {
        log.info(bauer.toString());
      }
      log.info("");
    };
  }
  
  private PersonTable getPersonTable(String string, String string2, String string3) {
    PersonTable person = new PersonTable();
    person.setName(string);
    person.setSurname(string2);
    person.setEmail(string3);
    return person;
  }
  
}
