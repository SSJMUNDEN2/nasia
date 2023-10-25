package ch.zhaw.nasia.Kunden;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
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
    @Field("kundenId")
    private String kundenId;

    @NonNull
    @Field("name")
    private String name;

    @NonNull
    @Field("telefonnummer")
    private String telefonnummer;

    @NonNull
    @Field("adresse")
    private String adresse;

    public Kunden(String kundenId, String name, String telefonnummer, String adresse) {
        this.kundenId = kundenId;
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
    }
}
