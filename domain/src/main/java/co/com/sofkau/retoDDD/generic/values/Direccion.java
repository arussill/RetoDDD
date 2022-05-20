package co.com.sofkau.retoDDD.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {

    private final String direccion;

    public Direccion(String direccion) {
        this.direccion =  Objects.requireNonNull(direccion, "Direccion no puede estar vacio") ;
    }

    @Override
    public String value() {
        return direccion;
    }
}
