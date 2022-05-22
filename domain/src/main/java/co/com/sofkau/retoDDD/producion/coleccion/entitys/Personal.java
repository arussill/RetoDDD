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
     * @param nombre El nombre
     * @param telefono El telefono
     */
    public Personal(PersonalId personalId, Nombre nombre, Telefono telefono) {
        super(personalId);
        this.personalId = personalId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Personal(Nombre nombre, Telefono telefono){
        super(new PersonalId());
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
