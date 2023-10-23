package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Lieferant.Lieferant;

@RestController

public class LieferantController {
    private ArrayList<Lieferant> listofLieferant;

    @GetMapping("/lieferant")
    public ArrayList<Lieferant> getLieferant() {
        return listofLieferant;
    }

    @PostMapping("/lieferant")
    public void addLieferant(Lieferant lieferant) {
        listofLieferant.add(lieferant);
    }

    @GetMapping("/lieferant/{id}")
    public Lieferant getLieferantById(int id) {
        return listofLieferant.get(id);
    }
}