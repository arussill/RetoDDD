package co.com.sofkau.retoDDD.producion.taller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;
import generic.values.Nombre;

public class UtileriaAgregada extends DomainEvent {
    private final UtileriaId utileriaId;
    private final Nombre nombre;

    public UtileriaAgregada(UtileriaId utileriaId, Nombre nombre) {
        super("co.com.sofkau.retoDDD.producion.UtileriaAgregada");
        this.utileriaId = utileriaId;
        this.nombre = nombre;
    }

    public UtileriaId getUtileriaId() {
        return utileriaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
