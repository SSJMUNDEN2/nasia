package ch.zhaw.nasia.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Logger;
import ch.zhaw.nasia.Kunden.Kunden;
import ch.zhaw.nasia.Kunden.KundenCreateDTO;
import ch.zhaw.nasia.repository.KundenRepository;

@RestController
@RequestMapping("/api")
public class KundenController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(KundenController.class);
    
    @Autowired
    KundenRepository kundenRepository;

    @PostMapping("/kunden")
    public ResponseEntity<Kunden> createKunden(
        @RequestBody KundenCreateDTO kDTO) {
            Kunden kDAO = new Kunden(kDTO.getKundenId(), kDTO.getName(), kDTO.getTelefonnummer(), kDTO.getAdresse());
            Kunden k = kundenRepository.save(kDAO);
            return new ResponseEntity<>(k, HttpStatus.CREATED);
    }

    @GetMapping("/kunden")
    public ResponseEntity <List<Kunden>> getAllKunden() {
        try {
            List<Kunden> alleKunden = kundenRepository.findAll();
            logger.info("Returned " + alleKunden.size() + " Kunden");
            return new ResponseEntity<>(alleKunden, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting Kunden: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
