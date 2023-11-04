package ch.zhaw.nasia.Bestellung;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("bestellung")
public class Bestellung {
    @Id
    private String bestellungId;
    
    private String kundenId;
    private String lieferantId;
    private String bestellungGerichtId;
    
    @NonNull
    private String lieferdauer;
    
    @NonNull
    private Status status = Status.OFFEN; 

    public Bestellung(String bestellungId, String kundenId, String lieferantId, String bestellungGerichtId, String lieferdauer) {
        this.bestellungId = bestellungId;
        this.kundenId = kundenId;
        this.lieferantId = lieferantId;
        this.bestellungGerichtId = bestellungGerichtId;
        this.lieferdauer = lieferdauer;
    }

    public void setLieferantId (String lieferantId) {
        this.lieferantId = null;
    }
}
