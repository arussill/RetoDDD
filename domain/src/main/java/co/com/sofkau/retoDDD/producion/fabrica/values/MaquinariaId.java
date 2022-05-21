package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class MaquinariaId extends Identity {

    public MaquinariaId(){

    }
    public MaquinariaId(String id) {
        super(id);
    }

    public static MaquinariaId of(String id) {
        return new MaquinariaId(id);
    }
}
