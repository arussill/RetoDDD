package co.com.sofkau.retoDDD.producion.fabrica.entitys;

import  co.com.sofka.domain.generic.Entity;
import co.com.sofkau.retoDDD.producion.fabrica.values.MaquinariaId;
import generic.values.Tipo;

public class Maquinaria extends Entity<MaquinariaId> {
    private final Tipo tipo;

    /**
     * Instantiates a new Entity.
     *
     * @param entityId the entity id
     * @param tipo
     */
    public Maquinaria(MaquinariaId entityId, Tipo tipo) {
        super(entityId);
        this.tipo = tipo;
    }
}
