package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;
import generic.values.Tipo;

public class Insumo extends Entity<InsumoId> {
    private final Tipo tipo;

    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     * @param tipo
     */
    public Insumo(InsumoId entityId, Tipo tipo) {
        super(entityId);
        this.tipo = tipo;
    }
}
