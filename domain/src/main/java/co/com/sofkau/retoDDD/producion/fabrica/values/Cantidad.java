package co.com.sofkau.retoDDD.producion.fabrica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {

    private final Integer cantidad;

    public Cantidad(Integer cantidad) {

        this.cantidad = Objects.requireNonNull(cantidad);

        if (this.cantidad > 100){
            throw new IllegalArgumentException("La cantidad no puede superar las 100 unidades");
        }
        if (this.cantidad <= 0){
            throw new IllegalArgumentException("La cantidad no puede ser igual a cero o negativa");
        }
    }

    @Override
    public Integer value() {
        return cantidad;
    }
}
