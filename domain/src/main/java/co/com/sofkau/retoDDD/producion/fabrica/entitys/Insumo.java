package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;
import generic.values.Tipo;

public class Insumo extends Entity<InsumoId> {
    private final InsumoId insumoId;
    private final Tipo tipo;

    /**
     * Instantiates a new Entity.
     *
     * @param insumoId the entity id
     * @param tipo
     */
    public Insumo(InsumoId insumoId, Tipo tipo) {
        super(insumoId);
        this.insumoId = insumoId;
        this.tipo = tipo;
    }
}
