package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Kunden.Kunden;

@RestController

public class KundenController {
    private ArrayList<Kunden> listofKunden;

    @GetMapping("/kunden")
    public ArrayList<Kunden> getKunden() {
        return listofKunden;
    }
}
