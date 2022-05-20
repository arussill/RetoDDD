package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.MoldeId;

public class Molde extends Entity<MoldeId> {
    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public Molde(MoldeId entityId) {
        super(entityId);
    }
}
