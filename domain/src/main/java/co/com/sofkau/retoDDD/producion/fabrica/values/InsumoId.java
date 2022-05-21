package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.Identity;

public class InsumoId extends Identity {
    public InsumoId(String id) {
        super(id);
    }

    public InsumoId(){

    }

    public static InsumoId of(String id) {
        return new InsumoId(id);
    }
}
