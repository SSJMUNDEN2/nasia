package ch.zhaw.nasia.Bestellung;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class BestellungCreateDTO {
    
    private int lieferdauer;
    private Status status;
}
