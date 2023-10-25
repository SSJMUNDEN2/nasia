package ch.zhaw.nasia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.nasia.BestellungGericht.BestellungGericht;

public interface BestellungGerichtRepository extends MongoRepository<BestellungGericht, String> {

    BestellungGericht findByBestellungGerichtid(String bestellungGerichtid);

}
