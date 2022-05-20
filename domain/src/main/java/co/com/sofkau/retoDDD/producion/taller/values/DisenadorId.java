package co.com.sofkau.retoDDD.producion.taller.values;

import co.com.sofka.domain.generic.Identity;

public class DisenadorId extends Identity {

    public DisenadorId(String id){
        super(id);
    }

    public DisenadorId() {

    }
    public static DisenadorId of(String id) {
        return new DisenadorId(id);
    }
}
