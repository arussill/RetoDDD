package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import  co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;

public class Maquinaria extends Entity<MaquinariaId> {
    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     */
    public Maquinaria(MaquinariaId entityId) {
        super(entityId);
    }
}
