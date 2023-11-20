package ch.zhaw.nasia.Bestellung;

import lombok.Getter;


@Getter
public class BestellungStateChangeDTO {
    private String bestellungId;
    private String lieferantId;

    public BestellungStateChangeDTO(String bestellungId, String lieferantId) {
        this.bestellungId = bestellungId;
        this.lieferantId = lieferantId;
    }
}
