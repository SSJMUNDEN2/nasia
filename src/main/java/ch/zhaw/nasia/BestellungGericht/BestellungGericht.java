package ch.zhaw.nasia.BestellungGericht;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@RequiredArgsConstructor
@Getter
@Setter
@Document("bestellungGericht")
public class BestellungGericht {
    private int bestellungGerichtid;
    private int gerichtsId;
    private int menge;
    private double gesamtpreis;
}
