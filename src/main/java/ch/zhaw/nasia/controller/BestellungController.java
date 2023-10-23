package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Bestellung.Bestellung;

@RestController

public class BestellungController {
        private ArrayList<Bestellung> listofBestellung;

        @GetMapping("/bestellung")
        public ArrayList<Bestellung> getBestellung() {
            return listofBestellung;
        }

        @PostMapping("/bestellung")
        public void addBestellung(Bestellung bestellung) {
            listofBestellung.add(bestellung);
        }

        @GetMapping("/bestellung/{id}")
        public Bestellung getBestellungById(int id) {
            return listofBestellung.get(id);
        }     
}
