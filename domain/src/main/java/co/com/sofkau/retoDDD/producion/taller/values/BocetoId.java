package co.com.sofkau.retoDDD.producion.taller.values;

import co.com.sofka.domain.generic.Identity;

public class BocetoId extends Identity {
    public BocetoId(String id) {
        super(id);
    }

    public BocetoId(){}

    public static BocetoId of(String id) {
        return new BocetoId(id);
    }
}
