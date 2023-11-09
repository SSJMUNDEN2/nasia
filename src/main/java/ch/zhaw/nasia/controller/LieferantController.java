package ch.zhaw.nasia.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Lieferant.Lieferant;
import ch.zhaw.nasia.Lieferant.LieferantCreateDTO;
import ch.zhaw.nasia.repository.LieferantRepository;

@RestController
@RequestMapping("/api")
public class LieferantController {

    @Autowired
    LieferantRepository lieferantRepository;

    @PostMapping("/lieferant")
    public ResponseEntity<Lieferant> createLieferant(
            @RequestBody LieferantCreateDTO lDTO) {
        Lieferant lDAO = new Lieferant(lDTO.getLieferantId(), lDTO.getName(), lDTO.getVerfügbarkeit());
        Lieferant l = lieferantRepository.save(lDAO);
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @GetMapping("/lieferant")
    public ResponseEntity<List<Lieferant>> getAllLieferant() {
        try {
            List<Lieferant> alleLieferant = lieferantRepository.findAll();
            return new ResponseEntity<>(alleLieferant, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lieferant/{lieferantId}")
    public ResponseEntity<Lieferant> getLieferantById(@PathVariable String lieferantId) {
        System.out.println("Get Lieferant by ID..." + lieferantId);
        Optional<Lieferant> lieferantData = lieferantRepository.findById(lieferantId);
        System.out.println("Lieferant by ID: " + lieferantData);
        if (lieferantData.isPresent()) {
            System.out.println("Lieferant by ID: " + lieferantData.get());
            return new ResponseEntity<>(lieferantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lieferant/verfügbar")
    public ResponseEntity<List<Lieferant>> getVerfügbarLieferant() {
        try {
            List<Lieferant> verfügbarLieferant = lieferantRepository.findByVerfügbarkeit("VERFÜGBAR");
            return new ResponseEntity<>(verfügbarLieferant, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}