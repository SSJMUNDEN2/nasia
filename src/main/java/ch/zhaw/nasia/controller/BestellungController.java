package ch.zhaw.nasia.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.zhaw.nasia.Bestellung.Bestellung;
import ch.zhaw.nasia.Bestellung.BestellungCreateDTO;
import ch.zhaw.nasia.repository.BestellungRepository;

@RestController
@RequestMapping("/api")
public class BestellungController {

    private static final Logger logger = LoggerFactory.getLogger(BestellungController.class);

    @Autowired
    BestellungRepository bestellungRepository;

    @PostMapping("/bestellung")
    public ResponseEntity<Bestellung> createBestellung(
            @RequestBody BestellungCreateDTO bDTO) {
        Bestellung bDAO = new Bestellung(bDTO.getBestellungId(), bDTO.getKundenId(), bDTO.getLieferantId(),
                bDTO.getBestellungGerichtId(), bDTO.getLieferdauer());
        Bestellung b = bestellungRepository.save(bDAO);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @GetMapping("/bestellung")
    public ResponseEntity<List<Bestellung>> getAllBestellung() {
        logger.info("Received getAllBestellung request");
        try {
            List<Bestellung> allBestellung = bestellungRepository.findAll();
            logger.info("Returned " + allBestellung.size() + " Bestellungen");
            return new ResponseEntity<>(allBestellung, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting Bestellungen: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bestellung/{bestellungId}")
    public ResponseEntity<Bestellung> getBestellungById(@PathVariable String bestellungId) {
        logger.info("Received request for bestellungId: " + bestellungId);
        Optional<Bestellung> b = bestellungRepository.findByBestellungId(bestellungId);
        if (b.isPresent()) {
            return new ResponseEntity<>(b.get(), HttpStatus.OK);
        }
        logger.warn("Bestellung not found for ID: " + bestellungId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
