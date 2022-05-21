package co.com.sofkau.retoDDD.producion.taller.values;

import co.com.sofka.domain.generic.Identity;

public class TallerId extends Identity {

    public TallerId(){

    }

    public TallerId(String id) {
        super(id);
    }

    public static TallerId of(String id) {
        return new TallerId(id);
    }
}
