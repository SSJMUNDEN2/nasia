package ch.zhaw.nasia.Lieferant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("lieferant")
public class Lieferant {
    private int lieferantId;
    private String name;
    private Verfügbarkeit verfügbarkeit;
}
