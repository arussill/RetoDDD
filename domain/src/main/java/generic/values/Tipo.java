package generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipo;

    public Tipo(String tipo) {
        this.tipo = Objects.requireNonNull(tipo);

        if (this.tipo.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return tipo;
    }
}
