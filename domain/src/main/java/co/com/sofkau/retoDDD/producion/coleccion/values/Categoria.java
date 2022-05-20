package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject<String> {
    private final String categoria;

    public Categoria(String categoria) {
        this.categoria = Objects.requireNonNull(categoria);

        if (this.categoria.isBlank()) {
            throw new IllegalArgumentException("El categoria no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return categoria;
    }
}
