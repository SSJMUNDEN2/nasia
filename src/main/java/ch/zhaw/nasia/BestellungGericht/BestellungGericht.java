package ch.zhaw.nasia.BestellungGericht;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

@Getter
@Setter

public class BestellungGericht {
    private int bestellungGerichtid;
    private int gerichtsId;
    private int menge;
    private double gesamtpreis;
}
