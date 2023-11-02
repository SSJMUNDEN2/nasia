package ch.zhaw.nasia.Bestellung;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
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
    @Field("bestellungId") 
    private String bestellungId;
    
    @Field("kundenId")
    private String kundenId;
    
    @Field("lieferantId")
    private String lieferantId;
    
    @Field("bestellungGerichtId")
    private String bestellungGerichtId;
    
    @NonNull
    @Field("lieferdauer")
    private String lieferdauer;
    
    @NonNull
    @Field("status")
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
