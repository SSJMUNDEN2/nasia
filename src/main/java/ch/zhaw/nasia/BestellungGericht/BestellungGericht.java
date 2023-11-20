package ch.zhaw.nasia.BestellungGericht;

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
@Document("bestellungGericht")
public class BestellungGericht {
    @Id
    private String bestellungGerichtid;

    @NonNull
    private String gerichtsId;

    @NonNull
    private String menge;

    private double gesamtpreis;

    public BestellungGericht(String bestellungGerichtid, String gerichtsId, String menge, double gesamtpreis) {
        this.bestellungGerichtid = bestellungGerichtid;
        this.gerichtsId = gerichtsId;
        this.menge = menge;
        this.gesamtpreis = gesamtpreis;
    }
}
