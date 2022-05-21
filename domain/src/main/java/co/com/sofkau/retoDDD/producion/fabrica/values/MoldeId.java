package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class MoldeId extends Identity {
    public MoldeId(String id) {
        super(id);
    }

    public MoldeId(){

    }

    public static MoldeId of(String id) {
        return new MoldeId(id);
    }
}
