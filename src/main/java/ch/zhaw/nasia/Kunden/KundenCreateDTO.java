package ch.zhaw.nasia.Kunden;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class KundenCreateDTO {
    private String name;
    private int telefonnummer;
    private String adresse;
}
