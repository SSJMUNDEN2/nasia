package ch.zhaw.nasia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.nasia.Kunden.Kunden;

public interface KundenRepository extends MongoRepository<Kunden, String>{
    
    Kunden findByKundenId(String kundenId);
}
