package ch.zhaw.nasia.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.nasia.Gericht.Gericht;


public interface GerichtRepository extends MongoRepository<Gericht, String> {
    Gericht findByName(String name);
}




