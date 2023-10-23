package ch.zhaw.nasia.Bestellung;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Bestellung {
    private int bestellungId;
    private int kundenId;
    private int lieferantId;
    private int bestellungGerichtId;
    private int lieferdauer;
    private Status status;
}
