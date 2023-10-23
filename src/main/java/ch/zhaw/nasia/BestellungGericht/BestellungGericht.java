package ch.zhaw.nasia.BestellungGericht;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BestellungGericht {
    
    private int bestellungGerichtid;
    private int gerichtsId;
    private int menge;
    private double gesamtpreis;
}
