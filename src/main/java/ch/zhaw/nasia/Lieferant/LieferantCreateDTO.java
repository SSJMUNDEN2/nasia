package ch.zhaw.nasia.Lieferant;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class LieferantCreateDTO {
    private String lieferantId;
    private String name;
    private Verfügbarkeit verfügbarkeit;
}
