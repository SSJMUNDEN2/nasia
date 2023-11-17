package ch.zhaw.nasia.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.nasia.Bestellung.Bestellung;

public interface BestellungRepository extends MongoRepository<Bestellung, String> {
    Optional<Bestellung> findByBestellungId(String bestellungId);
}

