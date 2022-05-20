package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Color implements ValueObject<String> {
   private final String color;

    public Color(String color) {
        this.color = Objects.requireNonNull(color);
        if (this.color.isBlank()) {
            throw new IllegalArgumentException("El color no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return color;
    }
}
