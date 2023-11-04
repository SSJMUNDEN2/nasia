package ch.zhaw.nasia.Lieferant;

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
@Document("lieferant")
public class Lieferant {
    @Id
    private String lieferantId;

    @NonNull
    private String name;
    
    private Verfügbarkeit verfügbarkeit = Verfügbarkeit.VERFÜGBAR;

    public Lieferant(String lieferantId, String name, Verfügbarkeit verfügbarkeit) {
        this.lieferantId = lieferantId;
        this.name = name;
        this.verfügbarkeit = verfügbarkeit;
    }

}
