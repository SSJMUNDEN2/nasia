package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Gericht.Gericht;

@RestController

public class GerichtController {
    private ArrayList<Gericht> listofGericht;

    @GetMapping("/gericht")
    public ArrayList<Gericht> getGericht() {
        return listofGericht;
    }

    @PostMapping("/gericht")
    public void addGericht(Gericht gericht) {
        listofGericht.add(gericht);
    }

    @GetMapping("/gericht/{id}")
    public Gericht getGerichtById(int id) {
        return listofGericht.get(id);
    }
}
