package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.Identity;

public class ColeccionId extends Identity {
    public ColeccionId(){

    }

    public ColeccionId(String id){
        super(id);
    }

    public static ColeccionId of(String id) {
        return new ColeccionId(id);
    }

}
