package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.BestellungGericht.BestellungGericht;

@RestController

public class BestellungGerichtController {
    private ArrayList<BestellungGericht> listofBestellungGericht;

    @GetMapping("/bestellungGericht")
    public ArrayList<BestellungGericht> getBestellungGericht() {
        return listofBestellungGericht;
    }
    
    @PostMapping("/bestellungGericht")
    public void addBestellungGericht(BestellungGericht bestellungGericht) {
        listofBestellungGericht.add(bestellungGericht);
    }

    @GetMapping("/bestellungGericht/{id}")
    public BestellungGericht getBestellungGerichtById(int id) {
        return listofBestellungGericht.get(id);
    }
}
