package ch.zhaw.nasia.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.nasia.Lieferant.Lieferant;
import ch.zhaw.nasia.Lieferant.Verfügbarkeit;

public interface LieferantRepository extends MongoRepository<Lieferant, String> {
    Lieferant findByLieferantId(String lieferantId);
    List<Lieferant> findByVerfügbarkeit(String string);
}


