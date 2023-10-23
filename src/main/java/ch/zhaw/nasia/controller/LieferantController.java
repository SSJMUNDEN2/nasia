package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Lieferant.Lieferant;

@RestController

public class LieferantController {
    private ArrayList<Lieferant> listofLieferant;

    @GetMapping("/lieferant")
    public ArrayList<Lieferant> getLieferant() {
        return listofLieferant;
    }
}
