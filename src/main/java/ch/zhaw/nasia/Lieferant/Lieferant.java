package ch.zhaw.nasia.Lieferant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@RequiredArgsConstructor
@Getter
@Setter
@Document("lieferant")
public class Lieferant {
    @Id
    private int lieferantId;
    @NonNull
    private String name;
    @NonNull
    private Verfügbarkeit verfügbarkeit;
}
