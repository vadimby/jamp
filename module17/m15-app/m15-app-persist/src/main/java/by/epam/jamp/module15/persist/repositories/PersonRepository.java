package by.epam.jamp.module15.persist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.epam.jamp.module15.persist.model.PersonTable;

@Repository
public interface PersonRepository  extends CrudRepository<PersonTable, Long>{

  List<PersonTable> findByEmail(String email);
  
}
