package by.epam.jamp.vvd.testapp.dao.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.epam.jamp.vvd.testapp.dao.model.TestData;

@Repository
public interface TestDataRepository extends JpaRepository<TestData, Long> {

	TestData findByKey(String key);

}
