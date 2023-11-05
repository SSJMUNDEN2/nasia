package ch.zhaw.nasia.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.zhaw.nasia.Bestellung.Bestellung;
import ch.zhaw.nasia.Bestellung.BestellungStateChangeDTO;
import ch.zhaw.nasia.Lieferant.Lieferant;
import ch.zhaw.nasia.service.BestellungService;
import ch.zhaw.nasia.service.LieferantService;

@RestController
@RequestMapping("/api/service")
public class ServiceBestellungController {

    private final BestellungService bestellungService;
    private final LieferantService lieferantService;

    @Autowired
    public ServiceBestellungController(BestellungService bestellungService, LieferantService lieferantService) {
        this.bestellungService = bestellungService;
        this.lieferantService = lieferantService;
    }

    
    @PutMapping("/unterwegs")
    public ResponseEntity<Bestellung> unterwegsBestellung(@RequestBody BestellungStateChangeDTO changeS) {
        System.out.println("Request received: " + changeS.toString());
        String bestellungId = changeS.getBestellungId();
        String lieferantId = changeS.getLieferantId();
        Optional<Bestellung> bestellung = bestellungService.UnterwegsBestellung(bestellungId, lieferantId);
        return bestellung.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/erledigt/{bestellungId}")
    public ResponseEntity<Bestellung> bestellungGeliefert(@PathVariable String bestellungId) {
        Optional<Bestellung> bestellungOptional = bestellungService.ErledigtBestellung(bestellungId);
        return bestellungOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/lieferantunterwegs/{lieferantId}")
    public ResponseEntity<Lieferant> lieferantUnterwegs(@PathVariable String lieferantId) {
        Optional<Lieferant> lieferant = lieferantService.LieferantUnterwegs(lieferantId);
        return lieferant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
