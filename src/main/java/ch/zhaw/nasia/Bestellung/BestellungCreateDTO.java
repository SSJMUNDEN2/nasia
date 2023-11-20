package ch.zhaw.nasia.Bestellung;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BestellungCreateDTO {  
    private String bestellungId;
    private String kundenId;
    private String lieferantId;
    private String bestellungGerichtId;
    private String lieferdauer;
    private Status status;
}
