package generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String value) {
        this.nombre = Objects.requireNonNull(value);

        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
    }

    public static Nombre of(String nombre){
        return new Nombre(nombre);
    }
    @Override
    public String value() {
        return nombre;
    }
}
