package ch.zhaw.nasia.Kunden;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@RequiredArgsConstructor
@Getter
@Setter
@Document("kunden")
public class Kunden { 
    private int kundenId;
    private String name;
    private int telefonnummer;
    private String adresse;
}
