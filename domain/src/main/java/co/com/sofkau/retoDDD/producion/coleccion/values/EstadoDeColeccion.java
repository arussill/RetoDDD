package co.com.sofkau.retoDDD.producion.coleccion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoDeColeccion implements ValueObject<EstadoDeColeccion.Estados> {

    private final Estados value;

    public EstadoDeColeccion(Estados value) {
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public Estados value() {
        return value;
    }

    public enum Estados {
        EN_PROCESO, FINALIZADO
    }
}