package ch.zhaw.nasia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Gericht.Gericht;
import ch.zhaw.nasia.Gericht.GerichtCreateDTO;
import ch.zhaw.nasia.repository.GerichtRepository;

@RestController
@RequestMapping("/api")
public class GerichtController {

    @Autowired
    GerichtRepository gerichtRepository;
    
    @PostMapping("/gericht")
    public ResponseEntity<Gericht> createGericht(
        @RequestBody GerichtCreateDTO gDTO) {
            Gericht gDAO = new Gericht(gDTO.getGerichtId(), gDTO.getName(), gDTO.getPreis());
            Gericht g = gerichtRepository.save(gDAO);
            return new ResponseEntity<>(g, HttpStatus.CREATED);         
    } 


    @GetMapping("/gericht/{gerichtId}")
    public ResponseEntity<Gericht> getGerichtById(@PathVariable String gerichtId) {
        Optional<Gericht> gerichtData = gerichtRepository.findById(gerichtId);
        if (gerichtData.isPresent()) {
            return new ResponseEntity<>(gerichtData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    
    
    @GetMapping("/gericht")
    public ResponseEntity<List<Gericht>> getAllGericht(
        @RequestParam(required = false) Double minPreis,
        @RequestParam(required = false) String name) {
        List<Gericht> alleGericht;
        if (minPreis == null && name == null) {
            alleGericht = gerichtRepository.findAll();
        } else if (minPreis != null) {
            alleGericht = gerichtRepository.findByPreisGreaterThan(minPreis);
        } else if (name != null) {
            alleGericht = gerichtRepository.findByName(name);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(alleGericht, HttpStatus.OK);
    }
}
