package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.Identity;

public class PruebaId extends Identity {

    public PruebaId (){

    }

    public PruebaId (String id){
        super(id);
    }

    public static PruebaId of(String id) {
        return  new PruebaId(id);
    }
}
