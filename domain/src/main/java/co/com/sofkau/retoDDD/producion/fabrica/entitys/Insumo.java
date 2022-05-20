package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.generic.values.Tipo;
import co.com.sofkau.retoDDD.producion.fabrica.values.InsumoId;

public class Insumo extends Entity<InsumoId> {
    protected InsumoId insumoId;
    protected Tipo tipo;

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
