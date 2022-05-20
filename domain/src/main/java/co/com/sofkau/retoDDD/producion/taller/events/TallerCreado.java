package co.com.sofkau.retoDDD.producion.taller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.taller.values.BocetoId;
import co.com.sofkau.retoDDD.producion.taller.values.DisenadorId;
import co.com.sofkau.retoDDD.producion.taller.values.UtileriaId;
import generic.values.Direccion;
import generic.values.Nombre;
import generic.values.Telefono;

public class TallerCreado extends DomainEvent {

    private final Nombre nombre;
    private final Direccion direccion;
    private final Telefono telefono;


    public TallerCreado(Nombre nombre, Direccion direccion, Telefono telefono) {
        super("co.com.sofkau.retoDDD.TallerCreado");
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
