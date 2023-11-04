package ch.zhaw.nasia.Gericht;

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
@Document("gericht")
public class Gericht {
    @Id
    private String gerichtId;

    @NonNull
    private String name;

    private double preis;

    public Gericht(String gerichtId, String name, double preis) {
        this.gerichtId = gerichtId;
        this.name = name;
        this.preis = preis;
    }

    public boolean isPresent() {
        return false;
    }

}
