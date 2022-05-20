package co.com.sofkau.retoDDD.producion.taller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.taller.values.DisenadorId;
import generic.values.Nombre;
import generic.values.Telefono;

public class DisenadorAgregado extends DomainEvent {
    private final DisenadorId disenadorId;
    private final Nombre nombre;
    private final Telefono telefono;

    public DisenadorAgregado(DisenadorId disenadorId, Nombre nombre, Telefono telefono) {
        super("co.com.sofkau.retoDDD.producion.DisenadorAgregado");
        this.disenadorId = disenadorId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public DisenadorId getDisenadorId() {
        return disenadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
