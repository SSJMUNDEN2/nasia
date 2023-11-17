package ch.zhaw.nasia.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.nasia.Gericht.Gericht;


public interface GerichtRepository extends MongoRepository<Gericht, String> {
    List<Gericht> findByPreisGreaterThan(Double minPreis);
    List<Gericht> findByPreisLessThan(Double maxPreis);
    List<Gericht> findByPreisBetween(Double minPreis, Double maxPreis);
    List<Gericht> findByName(String name);
}




