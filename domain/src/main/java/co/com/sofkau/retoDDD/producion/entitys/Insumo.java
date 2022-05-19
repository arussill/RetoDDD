package co.com.sofkau.retoDDD.producion.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.values.InsumoId;

public class Insumo extends Entity<InsumoId> {
    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public Insumo(InsumoId entityId) {
        super(entityId);
    }
}
