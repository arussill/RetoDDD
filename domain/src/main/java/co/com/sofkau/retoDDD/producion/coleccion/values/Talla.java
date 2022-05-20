package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Talla implements ValueObject<String> {
    private final String talla;

    public Talla(String talla) {
        this.talla = Objects.requireNonNull(talla);
        if (this.talla.isBlank()) {
            throw new IllegalArgumentException("El talla no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return talla;
    }
}
