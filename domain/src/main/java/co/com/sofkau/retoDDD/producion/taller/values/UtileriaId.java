package co.com.sofkau.retoDDD.producion.taller.values;

import co.com.sofka.domain.generic.Identity;

public class UtileriaId extends Identity {
    public UtileriaId(String id) {
        super(id);
    }

    public UtileriaId(){

    }

    public static UtileriaId of(String id) {
        return new UtileriaId(id);
    }
}
