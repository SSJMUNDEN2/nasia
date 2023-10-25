package ch.zhaw.nasia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.zhaw.nasia.BestellungGericht.BestellungGericht;
import ch.zhaw.nasia.repository.BestellungGerichtRepository;


@RestController
@RequestMapping("/api")
public class BestellungGerichtController {

    @Autowired
    BestellungGerichtRepository bestellungGerichtRepository;

    @PostMapping("/bestellungGericht")
    public ResponseEntity<BestellungGericht> createBestellungGericht(
            @RequestBody BestellungGericht beDTO) {
        BestellungGericht beDAO = new BestellungGericht(beDTO.getBestellungGerichtid(), beDTO.getGerichtsId(), beDTO.getMenge(), beDTO.getGesamtpreis());
        BestellungGericht be = bestellungGerichtRepository.save(beDAO);
        return new ResponseEntity<>(be, HttpStatus.CREATED);
    }

    @GetMapping("/bestellungGericht")
    public ResponseEntity<List<BestellungGericht>> getAllBestellungGericht() {
        try {
            List<BestellungGericht> allBestellungGericht = bestellungGerichtRepository.findAll();
            return new ResponseEntity<>(allBestellungGericht, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
