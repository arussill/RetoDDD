package co.com.sofkau.retoDDD.producion.taller.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion =  Objects.requireNonNull(descripcion, "Direccion no puede estar vacio") ;
    }

    @Override
    public String value() {
        return descripcion;
    }
}
