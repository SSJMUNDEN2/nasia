package ch.zhaw.nasia.BestellungGericht;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class BestellungGerichtCreateDTO {
    private int menge;
    private int gesamtpreis;
}
