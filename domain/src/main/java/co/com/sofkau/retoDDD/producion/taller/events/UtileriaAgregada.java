package co.com.sofkau.retoDDD.producion.taller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;

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
