package ch.zhaw.nasia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.nasia.Bestellung.Bestellung;

public interface BestellungRepository extends MongoRepository<Bestellung,String>{

    Bestellung findByBestellungId(String bestellungId);
}
