package co.com.sofkau.retoDDD.producion.coleccion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Nombre;
import co.com.sofkau.retoDDD.generic.values.Telefono;
import co.com.sofkau.retoDDD.producion.coleccion.values.PersonalId;

public class Personal extends Entity<PersonalId> {
    protected PersonalId personalId;
    protected Nombre nombre;
    protected Telefono telefono;

    /**
     * Instantiates a new Entity.
     *
     * @param personalId the entity id
     * @param nombre
     * @param telefono
     */
    public Personal(PersonalId personalId, Nombre nombre, Telefono telefono) {
        super(personalId);
        this.personalId = personalId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarInformacion(PersonalId personalId, Nombre nombre, Telefono telefono){
        this.personalId = PersonalId.of(Personal.this.personalId.value());
        this.nombre = Nombre.of(nombre.value());
        this.telefono = telefono.of(telefono.value());
    }
}
