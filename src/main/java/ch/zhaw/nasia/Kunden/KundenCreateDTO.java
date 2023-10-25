package ch.zhaw.nasia.Kunden;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class KundenCreateDTO {
    private String kundenId;
    private String name;
    private String telefonnummer;
    private String adresse;
}
