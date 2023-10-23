package ch.zhaw.nasia.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.nasia.Bestellung.Bestellung;

@RestController

public class BestellungController {
        private ArrayList<Bestellung> listofBestellung;

        @GetMapping("/bestellung")
        public ArrayList<Bestellung> getBestellung() {
            return listofBestellung;
        }
}
