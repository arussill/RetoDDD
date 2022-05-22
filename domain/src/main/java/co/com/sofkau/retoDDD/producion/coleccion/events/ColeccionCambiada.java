package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.coleccion.values.ColeccionId;

public class ColeccionCambiada extends DomainEvent {
    private final ColeccionId coleccionId;
    private final Nombre nombre;
    private final Telefono telefono;


    public ColeccionCambiada(ColeccionId coleccionId, Nombre nombre, Telefono telefono) {
        super("co.com.sofkau.retoDDD.producion.ColeccionCambiada");
        this.coleccionId = coleccionId;
        this.nombre = nombre;
        this.telefono = telefono;

    }

    public ColeccionId getColeccionId() {
        return coleccionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }


}
