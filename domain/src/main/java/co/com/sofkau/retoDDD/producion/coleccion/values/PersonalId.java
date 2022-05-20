package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.Identity;

public class PersonalId extends Identity {

    public PersonalId(String id){
        super(id);
    }

    public PersonalId() {

    }

    public static PersonalId of(String value) {
        return new PersonalId(value);
    }
}
