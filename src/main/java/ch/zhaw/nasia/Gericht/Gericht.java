package ch.zhaw.nasia.Gericht;

import lombok.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter


public class Gericht {
    private int gerichtId;
    @NonNull
    private String name;
    @NonNull
    private double preis;
}
