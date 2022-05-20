package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Resultado implements ValueObject<String> {
    private final String resultado;

    public Resultado(String resultado) {
        this.resultado = Objects.requireNonNull(resultado);
        if (this.resultado.isBlank()) {
            throw new IllegalArgumentException("El resultado no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return resultado;
    }
}
