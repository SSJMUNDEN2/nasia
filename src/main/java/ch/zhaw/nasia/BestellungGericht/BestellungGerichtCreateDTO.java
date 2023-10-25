package ch.zhaw.nasia.BestellungGericht;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class BestellungGerichtCreateDTO {
    private String bestellungGerichtid;
    private String gerichtsId;
    private String menge;
    private double gesamtpreis;
}
