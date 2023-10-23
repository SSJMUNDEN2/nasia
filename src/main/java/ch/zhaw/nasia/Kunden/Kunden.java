package ch.zhaw.nasia.Kunden;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("kunden")
public class Kunden { 
    private int kundenId;
    private String name;
    private int telefonnummer;
    private String adresse;
}
