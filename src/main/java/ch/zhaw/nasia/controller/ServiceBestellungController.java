package ch.zhaw.nasia.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.zhaw.nasia.Bestellung.Bestellung;
import ch.zhaw.nasia.Bestellung.BestellungStateChangeDTO;
import ch.zhaw.nasia.service.BestellungService; 

@RestController
@RequestMapping("/api/service")
public class ServiceBestellungController {

    private final BestellungService bestellungService;

    @Autowired
    public ServiceBestellungController(BestellungService bestellungService) {
        this.bestellungService = bestellungService;
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

}
