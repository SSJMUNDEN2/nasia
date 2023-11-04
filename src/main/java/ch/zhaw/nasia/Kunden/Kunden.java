package ch.zhaw.nasia.Kunden;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("kunden")

public class Kunden { 
    @Id
    private String kundenId;

    @NonNull
    private String name;

    @NonNull
    private String telefonnummer;

    @NonNull
    private String adresse;

    public Kunden(String kundenId, String name, String telefonnummer, String adresse) {
        this.kundenId = kundenId;
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }
}
