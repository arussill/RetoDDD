package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class FabricaId extends Identity {
    public FabricaId(String id) {
        super(id);
    }

    public FabricaId(){

    }

    public static FabricaId of(String id) {
        return new FabricaId(id);
    }
}
