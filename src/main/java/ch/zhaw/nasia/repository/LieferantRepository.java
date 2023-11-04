package ch.zhaw.nasia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.nasia.Lieferant.Lieferant;

public interface LieferantRepository extends MongoRepository<Lieferant, String> {

   Lieferant findByLieferantId(String lieferantId);

}
