package ch.zhaw.nasia.Gericht;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@RequiredArgsConstructor
@Getter
@Setter
@Document("gericht")
public class Gericht {
    private int gerichtId;
    @NonNull
    private String name;
    @NonNull
    private double preis;
}
