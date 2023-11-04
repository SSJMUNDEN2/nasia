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

    @GetMapping("/bestellung/{id}")
    public ResponseEntity<Bestellung> getBestellungById(@PathVariable String id) {
        logger.info("Received getBestellungById request");
        Optional<Bestellung> bestellungData = bestellungRepository.findById(id);
        if (bestellungData.isPresent()) {
            logger.info("Returned Bestellung with id " + id);
            return new ResponseEntity<>(bestellungData.get(), HttpStatus.OK);
        } else {
            logger.info("Bestellung with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
