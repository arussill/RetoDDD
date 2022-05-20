package co.com.sofkau.retoDDD.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Medidas implements ValueObject<Medidas.Pros> {

    private final String largo;
    private final String ancho;

    public Medidas(String largo, String ancho) {

        this.largo = Objects.requireNonNull(largo);
        this.ancho = Objects.requireNonNull(ancho);

        if (this.largo.isBlank() && this.ancho.isBlank()) {
            throw new IllegalArgumentException("Debe tener una tamaño no puede estar en blanco");
        }
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public String largo() {
                return largo;
            }

            @Override
            public String ancho() {
                return ancho;
            }
        };
    }

    public interface Pros {
        String largo();
        String ancho();
    }
}
