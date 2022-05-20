package co.com.sofkau.retoDDD.producion.coleccion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.coleccion.values.PersonalId;

public class Personal extends Entity<PersonalId> {
    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public Personal(PersonalId entityId) {
        super(entityId);
    }
}
