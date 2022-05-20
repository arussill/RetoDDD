package co.com.sofkau.retoDDD.producion.fabrica.events;

import co.com.sofka.domain.generic.DomainEvent;
import generic.values.Direccion;
import generic.values.Nombre;
import generic.values.Telefono;

public class FabricaCreada extends DomainEvent {

    private final Nombre nombre;
    private final Direccion direccion;
    private final Telefono telefono;

    public FabricaCreada(Nombre nombre, Direccion direccion, Telefono telefono) {
        super("co.com.sofkau.retoDDD.FabricaCreada ");
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
