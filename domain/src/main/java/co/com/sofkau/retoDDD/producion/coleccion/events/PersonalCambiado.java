package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;


public class PersonalCambiado extends DomainEvent {

    private final Nombre nombre;
    private final Telefono telefono;


    public PersonalCambiado(Nombre nombre, Telefono telefono) {
        super("co.com.sofkau.retoDDD.producion.PersonalCambiado");

        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }


}
