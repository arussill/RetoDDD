package co.com.sofkau.retoDDD.producion.coleccion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.retoDDD.producion.coleccion.values.PersonalId;
import generic.values.Nombre;
import generic.values.Telefono;

public class PersonalAgregado extends DomainEvent {
    private final PersonalId personalId;
    private final Nombre nombre;
    private final Telefono telefono;

    public PersonalAgregado(PersonalId personalId, Nombre nombre, Telefono telefono) {
        super("co.com.sofkau.retoDDD.producion.PersonalAgregado");
        this.personalId = personalId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
