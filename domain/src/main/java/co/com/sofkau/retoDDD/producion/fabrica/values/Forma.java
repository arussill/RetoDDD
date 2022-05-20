package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Forma implements ValueObject<String> {

    private final String forma;

    public Forma(String forma) {

        this.forma = Objects.requireNonNull(forma);

        if (this.forma.isBlank()) {
            throw new IllegalArgumentException("Debe tener una forma no puede estar en blanco");
        }
    }
    @Override
    public String value() {
        return forma;
    }
}
